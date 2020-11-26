package com.jhon.latihanspring.controller;

import com.jhon.latihanspring.DTO.ResponseDTO;
import com.jhon.latihanspring.repository.prodiRepository;
import com.jhon.latihanspring.service.prodiService;
import com.jhon.latihanspring.model.prodiModel;

import com.jhon.latihanspring.utils.ResponseEnum;
import com.jhon.latihanspring.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class prodiController {
    @Autowired
    private prodiRepository ProdiRepository;
    private prodiService ProdiSevice;

    @RequestMapping(value = "/prodi/save", method = RequestMethod.POST)
    public ResponseEntity saveProdi(@RequestBody prodiModel ProdiModel) {
        ProdiSevice.saveProdi(ProdiModel);
        return new ResponseEntity("Save Prodi Success", HttpStatus.OK);

    }

    @RequestMapping(value = "/prodi/searchname/{name}")
    public ResponseEntity searchByName(@PathVariable("name") String name) {
        return new ResponseEntity(ProdiSevice.searchByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/prodi")
    public ResponseDTO getALl() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setBody(ProdiSevice.getAll());
        ResponseUtils.setResponse(responseDTO, ResponseEnum.SUCCESS);
        return responseDTO;
    }

}
