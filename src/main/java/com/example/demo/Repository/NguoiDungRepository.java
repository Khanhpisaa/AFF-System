package com.example.demo.Repository;

import com.example.demo.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    Optional<NguoiDung> findByEmailAndMatKhau(String email, String matKhau);
    Optional<NguoiDung> findByEmail(String email);


}
