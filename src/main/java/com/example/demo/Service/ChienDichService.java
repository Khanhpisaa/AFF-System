package com.example.demo.Service;

import com.example.demo.Entity.ChienDich;
import com.example.demo.Repository.ChienDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChienDichService {

    @Autowired
    private ChienDichRepository chienDichRepository;

    public List<ChienDich> getAllChienDich() {
        return chienDichRepository.findAll();
    }
}
