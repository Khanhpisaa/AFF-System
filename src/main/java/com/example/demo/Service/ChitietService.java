package com.example.demo.Service;

import com.example.demo.Entity.ChiTietDonHang;
import com.example.demo.Repository.ChiTietDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChitietService {

    @Autowired
    ChiTietDonHangRepository chiTietDonHangRepository;

    public List<ChiTietDonHang> getAllChiTiet(){
        return chiTietDonHangRepository.findAll();
    }

    public ChiTietDonHang myinfoByMaChiTiet(Integer maChiTiet){
        return chiTietDonHangRepository.findById(maChiTiet).get();
    }
}
