package com.jhon.latihanspring.service.impl;

import com.jhon.latihanspring.model.nilaiModel;
import com.jhon.latihanspring.service.nilaiService;
import com.jhon.latihanspring.repository.nilaiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class implServiceNilai implements nilaiService {

    @Autowired
    private nilaiRepository NilaiRepository;

    @Override
    public void saveNilai(nilaiModel NilaiModel) {
        NilaiRepository.save(NilaiModel);
    }

    @Override
    public void delete(String kd_nilai) {
        NilaiRepository.deleteById(kd_nilai);
    }

    @Override
    public List<nilaiModel> getAll() {
        return NilaiRepository.findAll();
    }
}
