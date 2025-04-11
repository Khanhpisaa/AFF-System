package com.example.demo.Controller;

import com.example.demo.Entity.SanPham;
import com.example.demo.Service.SanPhamService;
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
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "0") int page) {
        int pageSize = 6;
        Pageable pageable = PageRequest.of(page, pageSize); // ✅ Dùng đúng import
        Page<SanPham> sanPhamPage = sanPhamService.getAllSanPham(pageable);

        model.addAttribute("listSanPham", sanPhamPage.getContent());
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

        model.addAttribute("sanPham", sanPham); // Sản phẩm chi tiết
        model.addAttribute("listSanPham", sanPhamPage.getContent()); // Danh sách SP phân trang
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "/SanPham/SanPhamDetail.html";
    }
    @GetMapping("/thanh-toan/{id}")
    public String hienThiTrangMua(@PathVariable("id") Integer id, Model model) {
        SanPham sanPham = sanPhamService.detailSanPham(id);
        model.addAttribute("sanPham", sanPham);
        return "/SanPham/SanPhamBuy.html";
    }
}
