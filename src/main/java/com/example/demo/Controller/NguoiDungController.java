package com.example.demo.Controller;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Service.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NguoiDungController {
    @Autowired
    NguoiDungService nguoiDungService;

    @GetMapping("/nguoi-dung/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("listNguoiDung",nguoiDungService.getALlNguoiDung());
        return "/NguoiDung.html";
    }


    // dang ky

    @GetMapping("/dang-ky")
    public String hienThiFormDangKy(Model model) {
        model.addAttribute("nguoiDung", new NguoiDung());
        return "DangNhap/DangKy.html";
    }

    @PostMapping("/dang-ky")
    public String dangKy(NguoiDung nguoiDung){
        nguoiDungService.addNguoiDung(nguoiDung);
        return "redirect:/dang-nhap";
    }

    @GetMapping("/dang-nhap")
    public String hienThiFormDangNhap() {
        return "/DangNhap/DangNhap.html";
    }

    // dang nhap
    @PostMapping("/dang-nhap")
    public String dangNhap(@RequestParam("email") String email,
                           @RequestParam("matKhau") String matKhau,
                           HttpSession session,
                           Model model) {
        NguoiDung nguoiDung = nguoiDungService.kiemTraDangNhap(email, matKhau);
        if (nguoiDung != null) {
            session.setAttribute("nguoiDung", nguoiDung);
            return "redirect:/san-pham/hien-thi";
        } else {
            model.addAttribute("error", "Email hoặc mật khẩu không đúng");
            return "/DangNhap/DangNhap.html";
        }
    }


}
