package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietDonHang;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Service.ChitietService;
import com.example.demo.Service.DonHangService;
import com.example.demo.Service.NguoiDungService;
import com.example.demo.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chi-tiet-don-hang")
public class ChiTietDonHangController {
    @Autowired
    ChitietService chitietService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    NguoiDungService nguoiDungService;

    @Autowired
    DonHangService donHangService;



    @GetMapping("/hien-thi")
    public String getALL(Model model){
        model.addAttribute("listChiTiet",chitietService.getAllChiTiet());
        model.addAttribute("donHang",donHangService.getALL());
        model.addAttribute("sanPham",sanPhamService.getALL());
        model.addAttribute("nguoiDung",nguoiDungService.getALlNguoiDung());
        return "/ChiTiet/ChiTiet";
    }

    @GetMapping("/chi-tiet-don-hang/myinfo/{maChiTiet}")
    public String hienThiChiTietDonHang(@PathVariable Integer maChiTiet, Model model) {
        ChiTietDonHang chiTiet = chitietService.myinfoByMaChiTiet(maChiTiet);
        model.addAttribute("chiTiet", chiTiet);
        return "/ChiTiet/ChiTiet";
    }

}
