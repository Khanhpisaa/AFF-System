package com.example.demo.Service;

import com.example.demo.Entity.GiaoDich;
import com.example.demo.Repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService {

    @Autowired
    private GiaoDichRepository giaoDichRepository;

    public List<GiaoDich> getAllGiaoDich() {
        return giaoDichRepository.findAll();
    }
}
