package com.example.demo.Service;

import com.example.demo.Entity.DoiTac;
import com.example.demo.Repository.DoiTacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoiTacService {
    @Autowired
    DoiTacRepository doiTacRepository;

    public List<DoiTac> getAllDoiTac (){
        return doiTacRepository.findAll();
    }

    public DoiTac getDoiTacByMaDoiTac (Integer maDoiTac){
        return doiTacRepository.findById(maDoiTac).get();
    }

    public void updateTrangThai1(Integer id){
        DoiTac doiTac = getDoiTacByMaDoiTac(id);
        doiTac.setTrangThai("Ngưng hợp tác");
        doiTacRepository.save(doiTac);
    }
    public void updateTrangThai2(Integer id){
        DoiTac doiTac = getDoiTacByMaDoiTac(id);
        doiTac.setTrangThai("Đang hợp tác");
        doiTacRepository.save(doiTac);
    }

}
