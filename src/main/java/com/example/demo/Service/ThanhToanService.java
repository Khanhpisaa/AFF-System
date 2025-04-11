package com.example.demo.Service;

import com.example.demo.Entity.ChiTietDonHang;
import com.example.demo.Entity.DonHang;
import com.example.demo.Entity.NguoiDung;
import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.ChiTietDonHangRepository;
import com.example.demo.Repository.DonHangRepository;
import com.example.demo.Repository.NguoiDungRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Request.ThanhToanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ThanhToanService {

    @Autowired
    private DonHangRepository donHangRepo;
    @Autowired private ChiTietDonHangRepository chiTietRepo;
    @Autowired private NguoiDungRepository nguoiDungRepo;
    @Autowired private SanPhamRepository sanPhamRepo;

    public DonHang taoDonHang(ThanhToanRequest req) {
        NguoiDung nguoiDung = nguoiDungRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));

        SanPham sanPham = sanPhamRepo.findById(req.getMaSanPham())
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

        BigDecimal donGia = sanPham.getGia();
        BigDecimal tongTien = donGia.multiply(BigDecimal.valueOf(req.getSoLuong()));

        DonHang donHang = new DonHang();
        donHang.setNguoiDung(nguoiDung);
        donHang.setTongTien(tongTien);
        donHang.setDiaChiGiaoHang(req.getDiaChiGiaoHang());
        donHang.setGhiChu(req.getGhiChu());

        ChiTietDonHang chiTiet = new ChiTietDonHang();
        chiTiet.setDonHang(donHang);
        chiTiet.setSanPham(sanPham);
        chiTiet.setSoLuong(req.getSoLuong());
        chiTiet.setDonGia(donGia);

        donHang.getChiTietDonHangs().add(chiTiet);

        return donHangRepo.save(donHang);
    }

}
