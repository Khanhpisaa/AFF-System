package com.example.demo.Request;

import lombok.Data;

@Data
public class DonHangRequest {
    private String tenNguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private double tongTien;
    private Long nguoiDungId;
}
