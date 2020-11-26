package com.jhon.latihanspring.service.impl;

import com.jhon.latihanspring.DTO.MahasiswaDTO;
import com.jhon.latihanspring.model.mahasiswaModel;
import com.jhon.latihanspring.service.mahasiswaService;
import com.jhon.latihanspring.repository.mahasiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class implServiceMahasiswa implements mahasiswaService {

    @Autowired
    private mahasiswaRepository MahasiswaRepository;

    @Override
    public void saveMahasiswa(mahasiswaModel MahasiswaModel) {
        MahasiswaRepository.save(MahasiswaModel);
    }

    @Override
    public List<Object[]> getGrupBy() {
        return MahasiswaRepository.gruByKelas();
    }

    @Override
    public List<Object[]> groupByClass(String kelas) {
        return MahasiswaRepository.groupByClass(kelas);

    }

    @Override
    public List<mahasiswaModel> getAll() {
        return MahasiswaRepository.findAll();
    }

    @Override
    public mahasiswaModel getMahasiswa(String nim) {
        return MahasiswaRepository.getOne(nim);
    }

    @Override
    public List<mahasiswaModel> searchByKelas(String kelas) {
        return MahasiswaRepository.searchByKelas(kelas);
    }

    @Override
    public mahasiswaModel getByKelasAndName(String name, String kelas) {
        return MahasiswaRepository.getByKelasAndName(name, kelas);
    }

    @Override
    public List<mahasiswaModel> searchByName(String name) {
        return MahasiswaRepository.searchByName(name);
    }

    @Override
    public void delete(String nim) {
        MahasiswaRepository.deleteById(nim);
    }

    @Override
    public Map getById(String nim) {
        mahasiswaModel MahasiswaModel = MahasiswaRepository.getOne(nim);
        Map map = new HashMap();
        if (null != MahasiswaModel) {
            map.put("nim", MahasiswaModel.getNim());
            map.put("name", MahasiswaModel.getName());
            map.put("kelas", MahasiswaModel.getKelas());
            map.put("semester", MahasiswaModel.getSemester());
        }
        return map;
    }

    @Override
    public void edit(MahasiswaDTO.Request MahasiswaModel, String nip) throws Exception {
        mahasiswaModel newMahasiswaModel = MahasiswaRepository.getOne(nip);

        if (null != newMahasiswaModel) {
            newMahasiswaModel.setName(MahasiswaModel.getName());
            newMahasiswaModel.setKelas(MahasiswaModel.getKelas());
            newMahasiswaModel.setSemester(MahasiswaModel.getSemester());

            MahasiswaRepository.save(newMahasiswaModel);
        } else throw new Exception("Mahasiswa Tidak Ditemukan");
    }


//    @Override
//    public void edit(String nim) throws Exception {
//        mahasiswaModel MahasiswaModel=new mahasiswaModel();
//        mahasiswaModel newMahasiswaModel=MahasiswaRepository.getOne(nim);
//
//        if(null!=newMahasiswaModel){
//            newMahasiswaModel.setName(MahasiswaModel.getName());
//            newMahasiswaModel.setKelas(MahasiswaModel.getKelas());
//            newMahasiswaModel.setSemester(MahasiswaModel.getSemester());
//
//            MahasiswaRepository.save(newMahasiswaModel);
//        }else throw new Exception ("Mahasiswa Tidak Ditemukan");
//    }


}
