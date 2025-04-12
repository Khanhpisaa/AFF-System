package com.example.demo.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DonHangRequest {
    private String tenNguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private double tongTien;
    private Long nguoiDungId;
}
