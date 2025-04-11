package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "DonHang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maChiTiet;

    @ManyToOne
    @JoinColumn(name = "maDonHang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    private int soLuong;
    private BigDecimal donGia;
}
