package com.example.demo.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class DonHangRequest {
    private String tenNguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private BigDecimal tongTien;
    private String email;
    private String ghiChu;
    private Long nguoiDungId;
}
