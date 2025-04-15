package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@Table(name = "DonHang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonHang;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDatHang;
    private BigDecimal tongTien;
    private String trangThai = "cho_xu_ly";
    private String ghiChu;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "diaChiGiaoHang")
    private String diaChiGiaoHang;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
}
