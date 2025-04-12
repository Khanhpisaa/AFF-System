package com.example.demo.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
public class ThanhToanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSanPham;
    private Integer soLuong;
    private String email;
    private String diaChiGiaoHang;
    private String ghiChu;
    private String hoTen;
}
