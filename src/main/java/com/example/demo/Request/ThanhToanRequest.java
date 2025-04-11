package com.example.demo.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
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
