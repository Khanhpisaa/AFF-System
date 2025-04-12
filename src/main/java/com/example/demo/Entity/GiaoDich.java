package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGiaoDich;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    private Integer soLuong;

    private BigDecimal tongTien;

    private LocalDate ngayGiaoDich;

    private String trangThai;
}
