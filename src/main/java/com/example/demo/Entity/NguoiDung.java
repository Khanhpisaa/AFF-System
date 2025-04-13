package com.example.demo.Entity;

import com.example.demo.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    String email;

    String matKhau;

    String hoTen;

    String soDienThoai;

    @Enumerated(EnumType.STRING)
    private Role vaiTro;

    public NguoiDung(String hoTen, String email) {
        this.hoTen = hoTen;
        this.email = email;
    }
}
