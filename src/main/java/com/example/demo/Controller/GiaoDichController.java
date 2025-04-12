package com.example.demo.Controller;

import com.example.demo.Service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiaoDichController {

    @Autowired
    private GiaoDichService giaoDichService;

    @GetMapping("/giao-dich/hien-thi")
    public String hienThiGiaoDich(Model model) {
        model.addAttribute("listGiaoDich", giaoDichService.getAllGiaoDich());
        return "/GiaoDich/GiaoDich.html";
    }
}
