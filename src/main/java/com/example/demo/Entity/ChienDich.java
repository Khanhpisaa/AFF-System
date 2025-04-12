package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChienDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maChienDich;

    private String tenChienDich;

    @Column(length = 1000)
    private String moTa;

    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String trangThai;
}
