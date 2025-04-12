package com.example.demo.Controller;

import com.example.demo.Service.HoaHongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HoaHongController {

    @Autowired
    private HoaHongService hoaHongService;

    @GetMapping("/hoa-hong/hien-thi")
    public String hienThiHoaHong(Model model) {
        model.addAttribute("listHoaHong", hoaHongService.getAllHoaHong());
        return "/HoaHong/HoaHong.html";
    }
}
