package com.example.demo.Request;

import com.example.demo.Entity.SanPham;
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
public class SanPhamBuyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSanPham;
    private String tenSanPham;
    private String tenNguoiNhan;
    private Integer soLuong;
    private String email;
    private String hoTen;
    private String diaChiGiaoHang;
    private BigDecimal gia;
    private String ghiChu;
    private String paymentMethod;

    public SanPhamBuyRequest(SanPham sanPham, Integer soLuong) {
        this.maSanPham = getMaSanPham();
        this.tenSanPham = getTenSanPham();
        this.soLuong = soLuong;
        this.gia = sanPham.getGia();
    }
}
