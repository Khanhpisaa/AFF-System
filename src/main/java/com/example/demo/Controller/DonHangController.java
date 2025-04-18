package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietDonHang;
import com.example.demo.Entity.DonHang;
import com.example.demo.Entity.NguoiDung;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.ChiTietDonHangRepository;
import com.example.demo.Repository.DonHangRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Request.DonHangRequest;
import com.example.demo.Service.DonHangService;
import com.example.demo.Service.NguoiDungService;
import com.example.demo.Service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class DonHangController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    NguoiDungService nguoiDungService;

    @Autowired
    DonHangService donHangService;

    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    ChiTietDonHangRepository chiTietDonHangRepository;



    @GetMapping("/don-hang/tao/{maSanPham}")
    public String taoHoaDon(@PathVariable("maSanPham") Integer maSanPham, Model model, HttpSession session) {
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("khachHang");
        if (nguoiDung == null) {
            System.out.println("chưa đăng nhập");
            return "redirect:/dang-nhap";
        }

        SanPham sanPham = sanPhamService.detailSanPham(maSanPham);

        DonHang donHang = new DonHang();
        donHang.setNguoiDung(nguoiDung);
        donHang.setNgayDatHang(new Date());
        donHang.setTrangThai("cho_xu_ly");

        ChiTietDonHang chiTiet = new ChiTietDonHang();
        chiTiet.setSanPham(sanPham);
        chiTiet.setSoLuong(1);
        chiTiet.setDonGia(sanPham.getGia());

        model.addAttribute("donHang", donHang);
        model.addAttribute("chiTiet", chiTiet);
        return "DonHang/TaoDonHang";
    }

    @PostMapping("/don-hang/luu")
    public String luuDonHang(@RequestParam("maSanPham") Integer maSanPham,
                             @RequestParam("soLuong") Integer soLuong,
                             @RequestParam("diaChiGiaoHang") String diaChi,
                             @RequestParam("ghiChu") String ghiChu,
                             HttpSession session,
                             Model model) {

        // Lấy người dùng hiện tại từ session
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("khachHang");

        if (nguoiDung == null) {
            return "redirect:/dang-nhap";
        }

        // Lấy sản phẩm
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(maSanPham);
        if (!optionalSanPham.isPresent()) {
            model.addAttribute("error", "Sản phẩm không tồn tại");
            return "redirect:/"; // Hoặc trang báo lỗi
        }
        SanPham sanPham = optionalSanPham.get();

        BigDecimal donGia = sanPham.getGia();
        BigDecimal tongTien = donGia.multiply(BigDecimal.valueOf(soLuong));

        // Tạo đơn hàng
        DonHang donHang = DonHang.builder()
                .nguoiDung(nguoiDung)
                .ngayDatHang(new Date())
                .diaChiGiaoHang(diaChi)
                .ghiChu(ghiChu)
                .soLuong(1)
                .tongTien(tongTien)
                .trangThai("cho_xu_ly")
                .build();
        donHangRepository.save(donHang);

        // Tạo chi tiết đơn hàng
        ChiTietDonHang chiTiet = new ChiTietDonHang();
        chiTiet.setDonHang(donHang);
        chiTiet.setSanPham(sanPham);
        chiTiet.setSoLuong(soLuong);
        chiTiet.setDonGia(tongTien);
        chiTietDonHangRepository.save(chiTiet);

        // Truyền dữ liệu sang view
        model.addAttribute("nguoiDung", nguoiDung);
        model.addAttribute("diaChiGiaoHang", diaChi);
        model.addAttribute("ghiChu", ghiChu);
        model.addAttribute("gioHang", List.of(chiTiet)); // 1 sản phẩm thôi
        model.addAttribute("tongTien", tongTien);

        return "/DonHang/ThanhToan";
    }

    @PostMapping("/thanh-toan/thanh-cong")
    public String thanhToanThanhCong(@RequestParam("maSanPham") Integer maSanPham,
                                     @RequestParam("phuongThuc") String phuongThuc,
                                     HttpSession session) {
        return "/DonHang/ThanhCong";
    }

}
