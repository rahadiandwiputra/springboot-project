package com.jhon.latihanspring.repository;

import com.jhon.latihanspring.model.mahasiswaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mahasiswaRepository extends JpaRepository<mahasiswaModel, String> {

    mahasiswaModel getByKelasAndName(String name, String kelas);

    @Query(value = "SELECT e.* FROM mahasiswa e WHERE  LOWER(e.name) = LOWER(:name)", nativeQuery = true)
    List<mahasiswaModel> searchByName(String name);

    @Query(value = "SELECT e.* FROM mahasiswa e WHERE  LOWER(e.kelas) = LOWER(:kelas)", nativeQuery = true)
    List<mahasiswaModel> searchByKelas(String kelas);

    @Query(value = "select nim, name, kelas from mahasiswa where LOWER(kelas) like LOWER(:kelas) group by nim", nativeQuery = true)
    List<Object[]> groupByClass(String kelas);

    @Query(value = "SELECT COUNT(nim), kelas FROM mahasiswa GROUP BY kelas", nativeQuery = true)
    List<Object[]> gruByKelas();


}
