package com.example.demo.Controller;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Entity.SanPham;
import com.example.demo.Service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model, HttpSession session,
                          @RequestParam(defaultValue = "0") int page) {
        int pageSize = 6;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SanPham> sanPhamPage = sanPhamService.getAllSanPham(pageable);

        NguoiDung khachHang = (NguoiDung) session.getAttribute("khachHang");
        model.addAttribute("listSanPham", sanPhamPage.getContent());
        if (khachHang != null) {
            model.addAttribute("tenNguoiDung", khachHang.getHoTen());
        }

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "/SanPham/SanPham.html";
    }

    @GetMapping("/detail/{id}")
    public String detailSanPham(@PathVariable("id") Integer id,
                                @RequestParam(defaultValue = "0") int page,
                                Model model) {
        int pageSize = 6;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SanPham> sanPhamPage = sanPhamService.getAllSanPham(pageable);

        SanPham sanPham = sanPhamService.detailSanPham(id);

        model.addAttribute("sanPham", sanPham);
        model.addAttribute("listSanPham", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "/SanPham/SanPhamDetail.html";
    }

    @GetMapping("/thanh-toan/{id}")
    public String hienThiTrangMua(@PathVariable("id") Integer id, Model model, HttpSession session) {
        SanPham sanPham = sanPhamService.detailSanPham(id);
        model.addAttribute("sanPham", sanPham);

        NguoiDung khachHang = (NguoiDung) session.getAttribute("khachHang");
        if (khachHang != null) {
            model.addAttribute("email", khachHang.getEmail());
            model.addAttribute("hoTen", khachHang.getHoTen());
        }

        return "/SanPham/SanPhamBuy.html";
    }
}
