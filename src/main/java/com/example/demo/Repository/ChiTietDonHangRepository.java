package com.example.demo.Repository;

import com.example.demo.Entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Integer> {

}
