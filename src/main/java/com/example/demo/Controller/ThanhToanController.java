package com.example.demo.Controller;

import com.example.demo.Entity.DonHang;
import com.example.demo.Entity.NguoiDung;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Request.SanPhamBuyRequest;
import com.example.demo.Service.ThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/thanh-toan")
public class ThanhToanController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @PostMapping("/mua")
    public String xuLyThanhToan(@ModelAttribute SanPhamBuyRequest request, Model model) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(request.getMaSanPham());

        if (optionalSanPham.isEmpty()) {
            return "redirect:/";
        }

        SanPham sanPham = optionalSanPham.get();

        // Gán lại dữ liệu vào request
        SanPhamBuyRequest sanPhamBuy = new SanPhamBuyRequest();
        sanPhamBuy.setMaSanPham(sanPham.getMaSanPham());
        sanPhamBuy.setSoLuong(request.getSoLuong());
        sanPhamBuy.setGia(sanPham.getGia());
        sanPhamBuy.setTenSanPham(sanPham.getTenSanPham());

        BigDecimal tongTien = sanPham.getGia().multiply(BigDecimal.valueOf(request.getSoLuong()));

        model.addAttribute("nguoiDung", new NguoiDung(request.getHoTen(), request.getEmail()));
        model.addAttribute("gioHang", List.of(sanPhamBuy));
        model.addAttribute("tongTien", String.format("%,.0f", tongTien));
        model.addAttribute("diaChiGiaoHang", request.getDiaChiGiaoHang());
        model.addAttribute("ghiChu", request.getGhiChu());

        return "ThanhToan/ThanhToan";
    }

    @PostMapping("/xac-nhan")
    public String xacNhanThanhToan(@RequestParam("email") String email,
                                   @RequestParam("hoTen") String hoTen,
                                   @RequestParam("diaChiGiaoHang") String diaChiGiaoHang,
                                   @RequestParam("ghiChu") String ghiChu,
                                   Model model) {

        model.addAttribute("hoTen", hoTen);
        model.addAttribute("email", email);
        model.addAttribute("diaChiGiaoHang", diaChiGiaoHang);
        model.addAttribute("ghiChu", ghiChu);

        return "ThanhToan/ThanhToanThanhCong";
    }
}
