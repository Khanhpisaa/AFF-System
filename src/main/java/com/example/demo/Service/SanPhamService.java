package com.example.demo.Service;

import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public Page<SanPham> getAllSanPham(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    public SanPham addSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public SanPham detailSanPham(Integer id) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        return optionalSanPham.orElse(null);
    }

}
