package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuotClick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLuotClick;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    private LocalDateTime thoiGianClick;

    private String diaChiIP;
}
