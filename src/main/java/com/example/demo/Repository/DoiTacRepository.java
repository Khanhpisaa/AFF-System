package com.example.demo.Repository;

import com.example.demo.Entity.DoiTac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiTacRepository extends JpaRepository<DoiTac, Integer> {
}
