package com.example.demo.Controller;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Enum.Role;
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

    // Hiển thị danh sách người dùng (Yêu cầu đã đăng nhập)
    @GetMapping("/nguoi-dung/hien-thi")
    public String hienthi(Model model, HttpSession session) {
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");

        if (nguoiDung == null) {  // Kiểm tra xem người dùng đã đăng nhập chưa
            return "redirect:/access-denied";  // Chưa đăng nhập thì chuyển đến trang access-denied
        }

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
    public String login(@RequestParam("email") String email, @RequestParam("matKhau") String matKhau, HttpSession session) {
        NguoiDung nguoiDung = nguoiDungService.findByEmail(email);

        if (nguoiDung != null && nguoiDung.getMatKhau().equals(matKhau)) {
            // Lưu thông tin người dùng vào session để kiểm tra sau
            session.setAttribute("nguoiDung", nguoiDung);

            if (nguoiDung.getVaiTro() == Role.Admin) {
                return "redirect:/admin";
            } else if (nguoiDung.getVaiTro() == Role.DoiTac) {
                return "redirect:/doitac";
            } else if (nguoiDung.getVaiTro() == Role.KhachHang) {
                return "redirect:/san-pham/hien-thi";
            }
        }
        return "redirect:/dang-nhap?error";  // Nếu đăng nhập không thành công, quay lại trang đăng nhập
    }

    // Trang Admin
    @GetMapping("/admin")
    public String adminPage(HttpSession session) {
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");

        if (nguoiDung == null) {  // Kiểm tra người dùng có đăng nhập hay không
            return "redirect:/access-denied";  // Nếu chưa đăng nhập thì chuyển đến trang access-denied
        }

        // Kiểm tra nếu người dùng là Đối Tác (DoiTac), chuyển hướng đến trang access-denied
        if (nguoiDung.getVaiTro() == Role.DoiTac) {
            return "redirect:/access-denied";  // Đối Tác không thể vào trang Admin
        }

        return "/Admin/Admin.html";  // Nếu là Admin, cho phép truy cập trang Admin
    }

    // Trang Đối Tác (DoiTac)
    @GetMapping("/doitac")
    public String doitacPage(HttpSession session) {
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");

        if (nguoiDung == null) {
            return "redirect:/access-denied";  // Nếu chưa đăng nhập thì chuyển đến trang access-denied
        }

        if (nguoiDung.getVaiTro() != Role.DoiTac) {
            return "redirect:/access-denied";  // Nếu không phải Đối Tác thì chuyển đến Access Denied
        }

        return "/DoiTac/DoiTac.html";  // Trang DoiTac cho Đối Tác
    }

    // Trang Access Denied (Không có quyền truy cập)
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/Access-Denied/Access-Denied.html";  // Trang thông báo không có quyền truy cập
    }

    // Đăng xuất
    @GetMapping("/dang-xuat")
    public String logout(HttpSession session) {
        session.removeAttribute("nguoiDung");  // Xóa thông tin người dùng trong session khi đăng xuất
        return "redirect:/dang-nhap";  // Sau khi đăng xuất, chuyển hướng về trang đăng nhập
    }
}
