package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "NguoiDung")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer maNguoiDung;

    String tenDangNhap;

    String email;

    String matKhau;

    String hoTen;

    String vaiTro;

    LocalDate ngayTao;

    public NguoiDung(String hoTen, String email) {
        this.hoTen = hoTen;
        this.email = email;
    }

}
