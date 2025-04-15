package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietDonHang;
import com.example.demo.Entity.DonHang;
import com.example.demo.Entity.NguoiDung;
import com.example.demo.Entity.SanPham;
import com.example.demo.Service.DonHangService;
import com.example.demo.Service.NguoiDungService;
import com.example.demo.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class DonHangController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    NguoiDungService nguoiDungService;

    @Autowired
    DonHangService donHangService;

    @GetMapping("/don-hang/tao/{maSanPham}")
    public String taoHoaDon(@PathVariable("maSanPham") Integer maSanPham, Model model, Principal principal){
        if (principal == null) {
            // Có thể redirect về trang login hoặc trả thông báo lỗi tùy bạn
            return "redirect:/dang-nhap";
        }
        SanPham sanPham = sanPhamService.detailSanPham(maSanPham);
        NguoiDung nguoiDung = nguoiDungService.findByEmail(principal.getName());

        DonHang donHang = new DonHang();
        donHang.setNguoiDung(nguoiDung);
        donHang.setNgayDatHang(new Date()); // dùng java.util.Date
        donHang.setTrangThai("cho_xu_ly");

        ChiTietDonHang chiTiet = new ChiTietDonHang();
        chiTiet.setSanPham(sanPham);
        chiTiet.setSoLuong(1); // mặc định
        chiTiet.setDonGia(sanPham.getGia());

        model.addAttribute("donHang", donHang);
        model.addAttribute("chiTiet", chiTiet);
        return "DonHang/TaoDonHang";
    }
    @PostMapping("/don-hang/luu")
    public String luuDonHang(@RequestParam("maSanPham") Integer maSanPham,
                             @RequestParam("soLuong") Integer soLuong,
                             @RequestParam("diaChiGiaoHang") String diaChi,
                             Principal principal) {

        NguoiDung nguoiDung = nguoiDungService.findByEmail(principal.getName());
        SanPham sanPham = sanPhamService.detailSanPham(maSanPham);

        BigDecimal thanhTien = sanPham.getGia().multiply(BigDecimal.valueOf(soLuong));

        DonHang donHang = new DonHang();
        donHang.setNguoiDung(nguoiDung);
        donHang.setNgayDatHang(new Date());
        donHang.setDiaChiGiaoHang(diaChi);
        donHang.setSoLuong(soLuong);
        donHang.setTongTien(thanhTien);
        donHang.setTrangThai("cho_xu_ly");

        ChiTietDonHang chiTiet = new ChiTietDonHang();
        chiTiet.setDonHang(donHang);
        chiTiet.setSanPham(sanPham);
        chiTiet.setSoLuong(soLuong);
        chiTiet.setDonGia(sanPham.getGia());

        donHang.setChiTietDonHangs(List.of(chiTiet));

        donHangService.taoDonHang(donHang); // bạn cần tạo service này

        return "redirect:/don-hang/thanh-cong"; // bạn tạo thêm trang này hiển thị thông báo
    }

}
