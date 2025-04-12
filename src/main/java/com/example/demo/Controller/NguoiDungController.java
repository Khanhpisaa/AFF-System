package com.example.demo.Controller;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Service.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NguoiDungController {

    @Autowired
    NguoiDungService nguoiDungService;

    // Hiển thị danh sách người dùng
    @GetMapping("/nguoi-dung/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listNguoiDung", nguoiDungService.getALlNguoiDung());
        return "/NguoiDung.html";
    }

    // Trang đăng ký
    @GetMapping("/dang-ky")
    public String hienThiFormDangKy(Model model) {
        model.addAttribute("nguoiDung", new NguoiDung());
        return "DangNhap/DangKy.html";
    }

    @PostMapping("/dang-ky")
    public String dangKy(NguoiDung nguoiDung) {
        nguoiDungService.addNguoiDung(nguoiDung);
        return "redirect:/dang-nhap";
    }

    // Trang đăng nhập
    @GetMapping("/dang-nhap")
    public String hienThiFormDangNhap() {
        return "/DangNhap/DangNhap.html";
    }

    @PostMapping("/dang-nhap")
    public String login(@RequestParam("email") String email,
                        @RequestParam("matKhau") String matKhau,
                        HttpSession session) {
        NguoiDung nguoiDung = nguoiDungService.findByEmail(email);

        if (nguoiDung != null && nguoiDung.getMatKhau().equals(matKhau)) {
            session.setAttribute("nguoiDung", nguoiDung);
            return "redirect:/san-pham/hien-thi";  // Sau khi đăng nhập thành công, về trang chủ hoặc trang tùy chọn
        }

        return "redirect:/dang-nhap?error";
    }

    // Đăng xuất
    @GetMapping("/dang-xuat")
    public String logout(HttpSession session) {
        session.removeAttribute("nguoiDung");
        return "redirect:/dang-nhap";
    }
}
