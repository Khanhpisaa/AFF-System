package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@Table(name = "DoiTac")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoiTac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer MaDoiTac;

    String MaDoiTacCode;

    LocalDate NgayThamGia;

    String TrangThai;

}
