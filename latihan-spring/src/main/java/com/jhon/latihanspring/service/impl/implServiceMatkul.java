package com.jhon.latihanspring.service.impl;

import com.jhon.latihanspring.repository.matkulRepository;
import com.jhon.latihanspring.service.matkulService;

import com.jhon.latihanspring.model.matkulModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class implServiceMatkul implements matkulService {

    @Autowired
    private matkulRepository MatkulRepository;

    @Override
    public void save(matkulModel MatkulModel) {
        MatkulRepository.save(MatkulModel);
    }

    @Override
    public void delete(String kd_matkul) {
        MatkulRepository.deleteById(kd_matkul);
    }

    @Override
    public List<matkulModel> getAll() {
        return MatkulRepository.findAll();
    }
}
