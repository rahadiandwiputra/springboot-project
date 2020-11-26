package com.jhon.latihanspring.service;

import com.jhon.latihanspring.DTO.MahasiswaDTO;
import com.jhon.latihanspring.model.mahasiswaModel;

import java.util.List;
import java.util.Map;

public interface mahasiswaService {
    void saveMahasiswa(mahasiswaModel MahasiswaModel);
    List<Object[]>getGrupBy();
    List<Object[]>groupByClass(String kelas);
    List<mahasiswaModel>getAll();
    mahasiswaModel getMahasiswa(String nim);
    List<mahasiswaModel> searchByKelas(String kelas);
    mahasiswaModel getByKelasAndName(String name, String kelas);
    List<mahasiswaModel> searchByName(String name);
    void delete(String nim);
    Map getById(String nim);
    //    EmployeeDto.Response getWithDto(String nip);
    void edit(MahasiswaDTO.Request employee, String nip) throws Exception;

}
