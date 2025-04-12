package com.example.demo.Service;

import com.example.demo.Entity.HoaHong;
import com.example.demo.Repository.HoaHongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaHongService {

    @Autowired
    private HoaHongRepository hoaHongRepository;

    public List<HoaHong> getAllHoaHong() {
        return hoaHongRepository.findAll();
    }
}
