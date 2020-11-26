package com.jhon.latihanspring.controller;

import com.jhon.latihanspring.DTO.ResponseDTO;
import com.jhon.latihanspring.service.matkulService;
import com.jhon.latihanspring.model.matkulModel;

import com.jhon.latihanspring.utils.ResponseEnum;
import com.jhon.latihanspring.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class matkulController {
    @Autowired
    private matkulService MatkulService;

    @RequestMapping(value = "/matkul/save", method = RequestMethod.POST)
    public ResponseEntity saveMatkul(matkulModel MatkulModel) {
        MatkulService.save(MatkulModel);
        return new ResponseEntity("Data Matakuliah Berhasil di Simpan", HttpStatus.OK);
    }

    @RequestMapping(value = "/matkul", method = RequestMethod.GET)
    public ResponseDTO getAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setBody(MatkulService.getAll());
        ResponseUtils.setResponse(responseDTO, ResponseEnum.SUCCESS);
        return responseDTO;
    }

    @RequestMapping(value = "/matkul/delete", method = RequestMethod.DELETE)
    public ResponseEntity delete(String kd_matkul) {
        MatkulService.delete(kd_matkul);
        return new ResponseEntity("Data Matkul = " + kd_matkul + " Berhasil dihapus", HttpStatus.OK);
    }
}
