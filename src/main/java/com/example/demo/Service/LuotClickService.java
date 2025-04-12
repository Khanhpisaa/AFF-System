package com.example.demo.Service;

import com.example.demo.Entity.LuotClick;
import com.example.demo.Repository.LuotClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuotClickService {

    @Autowired
    private LuotClickRepository luotClickRepository;

    public List<LuotClick> getAllLuotClick() {
        return luotClickRepository.findAll();
    }
}
