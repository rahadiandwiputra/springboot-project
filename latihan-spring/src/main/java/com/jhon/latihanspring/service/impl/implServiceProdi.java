package com.jhon.latihanspring.service.impl;

import com.jhon.latihanspring.model.prodiModel;
import com.jhon.latihanspring.repository.prodiRepository;
import com.jhon.latihanspring.service.prodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class implServiceProdi implements prodiService {
    @Autowired
    private prodiRepository ProdiRepository;
    private prodiService ProdiService;

    @Override
    public void saveProdi(prodiModel ProdiModel) {
        ProdiRepository.save(ProdiModel);
    }

    @Override
    public List<prodiModel> searchByName(String name) {
        return ProdiRepository.searchByName(name);
    }

    @Override
    public Map getById(String id) {
        prodiModel ProdiModel = ProdiRepository.getOne(id);
        Map map = new HashMap();
        if (null != ProdiModel) {
            map.put("kd_prodi", ProdiModel.getId());
            map.put("name", ProdiModel.getName());

        }
        return map;
    }

    @Override
    public List<prodiModel> getAll() {
        return ProdiRepository.findAll();
    }
}
