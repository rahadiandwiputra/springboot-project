package com.jhon.latihanspring.controller;

import com.jhon.latihanspring.DTO.ResponseDTO;
import com.jhon.latihanspring.model.nilaiModel;
import com.jhon.latihanspring.service.nilaiService;
import com.jhon.latihanspring.repository.nilaiRepository;

import com.jhon.latihanspring.utils.ResponseEnum;
import com.jhon.latihanspring.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class nilaiController {
    @Autowired
    private nilaiService NilaiService;

    @Autowired
    private nilaiRepository NilaiRepository;

    @RequestMapping(value = "/nilai/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody nilaiModel NilaiModel) {
        NilaiService.saveNilai(NilaiModel);
        return new ResponseEntity("Data Nilai Berhasil di Simpan", HttpStatus.OK);
    }

    @RequestMapping(value = "/nilai", method = RequestMethod.GET)
    public ResponseDTO getAll() {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setBody(NilaiService.getAll());
        ResponseUtils.setResponse(responseDTO, ResponseEnum.SUCCESS);
        return responseDTO;
    }

    @RequestMapping(value = "/nilai/delete", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("kd_nilai") String kd_nilai) {
        NilaiService.delete(kd_nilai);
        return new ResponseEntity("Data Nilai = " + kd_nilai + " Berhasil Dihapus", HttpStatus.OK);
    }

}
