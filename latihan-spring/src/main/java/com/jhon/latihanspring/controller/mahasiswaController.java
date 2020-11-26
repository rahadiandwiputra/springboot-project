package com.jhon.latihanspring.controller;

import com.jhon.latihanspring.DTO.MahasiswaDTO;
import com.jhon.latihanspring.DTO.ResponseDTO;
import com.jhon.latihanspring.model.mahasiswaModel;
import com.jhon.latihanspring.service.mahasiswaService;
import com.jhon.latihanspring.repository.mahasiswaRepository;

import com.jhon.latihanspring.utils.ResponseEnum;
import com.jhon.latihanspring.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class mahasiswaController {
    @Autowired
    private mahasiswaService MahasiswaService;
    @Autowired
    private mahasiswaRepository MahasiswaRepository;

    //save data 'mahasiswa' using input
    @RequestMapping(value = "/mahasiswa/save", method = RequestMethod.POST)
    public ResponseEntity saveMahasiswa(@RequestBody mahasiswaModel MahasiswaModel) {
        MahasiswaService.saveMahasiswa(MahasiswaModel);
        return new ResponseEntity("Save Mahasiswa Sukses", HttpStatus.OK);
    }

    //Show All Data
    @RequestMapping(value = "/mahasiswa")
    public ResponseDTO getAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setBody(MahasiswaService.getAll());
        ResponseUtils.setResponse(responseDTO, ResponseEnum.SUCCESS);
        return responseDTO;
    }

    //seach by 'nim' or 'id'
    @RequestMapping(value = "/mahasiswa/{nim}")
    public ResponseEntity getMahasiswa(@PathVariable("nim") String nim) {
        return new ResponseEntity(MahasiswaService.getMahasiswa(nim), HttpStatus.OK);
    }

    //search by 'kelas'
    @RequestMapping(value = "/mahasiswa/{kelas}/kelas")
    public ResponseEntity searchBykelas(@PathVariable("kelas") String kelas) {
        return new ResponseEntity(MahasiswaService.searchByKelas(kelas), HttpStatus.OK);
    }

    //get by 'name' and 'kelas' 2 parameters
    @RequestMapping(value = "/mahasiswa/{name}/{kelas}/getNamaKelas")
    public ResponseEntity getByKelasAndName(@PathVariable("name") String name, @PathVariable("kelas") String kelas) {
        return new ResponseEntity(MahasiswaService.getByKelasAndName(name, kelas), HttpStatus.OK);
    }

    //edit by 'nim' or 'id'
    @RequestMapping(value = "/mahasiswa/{nim}/edit", method = RequestMethod.PUT)
    public ResponseEntity editMahasiswa(@RequestBody @Validated MahasiswaDTO.Request MahasiswaModel, @PathVariable("nim") String nim) throws Exception {
        MahasiswaService.edit(MahasiswaModel, nim);

        return new ResponseEntity("Edit Mahasiswa Success", HttpStatus.OK);
    }

    // search by 'name'
    @RequestMapping(value = "/mahasiswa/{name}/name")
    public ResponseEntity searchByname(@PathVariable("name") String name) {
        return new ResponseEntity(MahasiswaService.searchByName(name), HttpStatus.OK);
    }

    //group by id where 'kelas' in certain condition (using input)
    @RequestMapping(value = "/mahasiswa/{kelas}/group")
    public Map<BigInteger, String> groupByClass(@PathVariable("kelas") String kelas) {
        List<Object[]> result = MahasiswaService.groupByClass(kelas);
        Map<BigInteger, String> map = null;
        if (result != null && !result.isEmpty()) {
            map = new HashMap<BigInteger, String>();
            for (Object[] object : result) {
                map.put(((BigInteger) object[0]), (String) object[1]);
            }
        }
        return map;
    }

    //group by kelas where 'kelas' in certain condition (not use input)
    @RequestMapping(value = "/mahasiswa/groupBy", method = RequestMethod.GET)
    public Map<BigInteger, String> groupBy() {
        List<Object[]> result = MahasiswaService.getGrupBy();
        Map<BigInteger, String> map = null;
        if (result != null && !result.isEmpty()) {
            map = new HashMap<BigInteger, String>();
            for (Object[] object : result) {
                map.put(((BigInteger) object[0]), (String) object[1]);
            }
        }
        return map;
    }

    // delete by id
    @RequestMapping(value = "/mahasiswa/{nim}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable("nim") String nim) {
        MahasiswaService.delete(nim);
        return new ResponseEntity("NIM : " + nim + " Berhasil Dihapus", HttpStatus.OK);
    }

    // search by 'name' and 'kelas' 2 parameters
    @RequestMapping(value = "/mahasiswa/search", method = RequestMethod.GET)
    public ResponseEntity withParams(@RequestParam Optional<String> name, @RequestParam Optional<String> kelas) {

        if (kelas.isPresent() && name.isPresent()) {
            System.out.println("kelas & name");
        } else if (name.isPresent()) {
            System.out.println("name");
        } else if (kelas.isPresent())
            System.out.println("kelas");

        return new ResponseEntity("Sukses", HttpStatus.OK);
    }


}
