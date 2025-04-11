package com.example.demo.Request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ThanhToanRequest {
    private Integer maSanPham;
    private Integer soLuong;
    private String email;
    private String diaChiGiaoHang;
    private String ghiChu;
    private String hoTen;
}
