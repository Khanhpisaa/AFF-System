package com.example.demo.Service;

import com.example.demo.Entity.DonHang;
import com.example.demo.Repository.DonHangRepository;
import com.example.demo.Request.DonHangRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService {
    @Autowired
    DonHangRepository donHangRepository;

     public void taoDonHang(DonHang donHang){
         donHangRepository.save(donHang);
     }

     public List<DonHang> getALL(){
         return donHangRepository.findAll();
     }

}
