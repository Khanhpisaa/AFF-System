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
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonHang;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    private LocalDateTime ngayDatHang = LocalDateTime.now();
    private BigDecimal tongTien;
    private String trangThai = "cho_xu_ly";
    private String diaChiGiaoHang;
    private String ghiChu;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
    // Getters và setters
}
