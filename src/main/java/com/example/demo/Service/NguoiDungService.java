package com.example.demo.Service;

import com.example.demo.Entity.NguoiDung;
import com.example.demo.Repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Đăng nhập
    public NguoiDung kiemTraDangNhap(String email, String matKhau) {
        List<NguoiDung> ketQua = nguoiDungRepository.findByEmailAndMatKhau(email, matKhau);
        if (ketQua != null && !ketQua.isEmpty()) {
            return ketQua.get(0); // Lấy người đầu tiên
        }
        return null;
    }

    // Tìm người dùng theo email
    public NguoiDung findByEmail(String email) {
        List<NguoiDung> users = nguoiDungRepository.findFirstByEmail(email);
        if (users.size() > 1) {
            // Xử lý khi có nhiều kết quả trùng
            throw new RuntimeException("Multiple users found with the same email");
        }
        return users.isEmpty() ? null : users.get(0);
    }
}
