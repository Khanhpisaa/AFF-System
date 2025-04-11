package com.example.demo.Service;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Service
public class NguoiDungService {

    @Autowired
    NguoiDungRepository nguoiDungRepository;

    public List<NguoiDung> getALlNguoiDung(){
        return nguoiDungRepository.findAll();
    }

    public void addNguoiDung(NguoiDung nguoiDung){
        nguoiDungRepository.save(nguoiDung);
    }

    // dang nhap - dang ky

    public NguoiDung kiemTraDangNhap(String email, String matKhau) {
        return nguoiDungRepository.findByEmailAndMatKhau(email, matKhau).orElse(null);
    }
}
