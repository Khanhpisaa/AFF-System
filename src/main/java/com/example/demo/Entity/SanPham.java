package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "SanPham")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer MaSanPham;

    String TenSanPham;

    String MoTa;

    BigDecimal Gia;

    LocalDate NgayTao;

    String Anh;
}
