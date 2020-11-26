package com.jhon.latihanspring.service;

import com.jhon.latihanspring.model.matkulModel;

import java.util.List;

public interface matkulService {
    void save(matkulModel MatkulModel);

    void delete(String kd_matkul);

    List<matkulModel> getAll();
}
