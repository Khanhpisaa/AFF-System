package com.example.demo.Controller;

import com.example.demo.Service.LuotClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LuotClickController {

    @Autowired
    private LuotClickService luotClickService;

    @GetMapping("/luot-click")
    public String hienThiLuotClick(Model model) {
        model.addAttribute("dsLuotClick", luotClickService.getAllLuotClick());
        return "/LuotClick/DanhSach";
    }
}
