package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class HoaHong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHoaHong;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "maGiaoDich")
    private GiaoDich giaoDich;

    private BigDecimal soTienHoaHong;

    private LocalDate ngayNhan;

    private String trangThai;
}
