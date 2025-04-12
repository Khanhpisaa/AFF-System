package com.example.demo.Service;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

@Service
public class
NguoiDungService {

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

    public NguoiDung findByEmail(String email) {
        List<NguoiDung> users = nguoiDungRepository.findFirstByEmail(email);
        if (users.size() > 1) {
            // Xử lý khi có nhiều kết quả trùng
            throw new RuntimeException("Multiple users found with the same email");
        }
        return users.isEmpty() ? null : users.get(0);
    }
}
