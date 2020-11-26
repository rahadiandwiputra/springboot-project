package com.jhon.latihanspring.service;

import com.jhon.latihanspring.model.prodiModel;
import  com.jhon.latihanspring.DTO.ProdiDTO;

import java.util.List;
import java.util.Map;

public interface prodiService {
    void saveProdi(prodiModel ProdiModel);
    List<prodiModel> searchByName(String name);
    Map getById(String id);
//    ProdiDTO.Response getWithDto(String id);
    List<prodiModel> getAll();


}
