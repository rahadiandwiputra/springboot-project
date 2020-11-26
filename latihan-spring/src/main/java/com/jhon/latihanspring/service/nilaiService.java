package com.jhon.latihanspring.service;

import com.jhon.latihanspring.model.nilaiModel;

import java.util.List;

public interface nilaiService {
    void saveNilai(nilaiModel NilaiMahasiswa);

    void delete(String kd_nilai);

    List<nilaiModel> getAll();
}
