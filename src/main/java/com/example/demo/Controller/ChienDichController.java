package com.example.demo.Controller;

import com.example.demo.Service.ChienDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChienDichController {

    @Autowired
    private ChienDichService chienDichService;

    @GetMapping("/chien-dich")
    public String hienThiDanhSach(Model model) {
        model.addAttribute("dsChienDich", chienDichService.getAllChienDich());
        return "/ChienDich/ChienDich";
    }
}
