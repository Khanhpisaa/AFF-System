package com.example.demo.Controller;

import com.example.demo.Service.DoiTacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doi-tac")
public class DoiTacController {
    @Autowired
    DoiTacService doiTacService;

    @GetMapping("/hien-thi")
    public String hienThi (Model model){
        model.addAttribute("listDoiTac", doiTacService.getAllDoiTac());
        return "/DoiTac/DoiTac.html";
    }

    @GetMapping("/update-trang-thai/{MaDoiTac}")
    public String ngungHopTac (@PathVariable("MaDoiTac") Integer maDoiTac){
        doiTacService.updateTrangThai1(maDoiTac);
        return "redirect:/doi-tac/hien-thi";
    }

    @GetMapping("/update-trang-thai1/{MaDoiTac}")
    public String HopTac (@PathVariable("MaDoiTac") Integer maDoiTac){
        doiTacService.updateTrangThai2(maDoiTac);
        return "redirect:/doi-tac/hien-thi";
    }

}
