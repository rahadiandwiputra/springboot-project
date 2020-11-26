package com.jhon.latihanspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jhon.latihanspring.DTO.MahasiswaDTO;

import javax.persistence.*;

@Entity
@Table(name = "nilai")
public class nilaiModel {
    @Id
    @Column(name = "kd_nilai")
    private Long kd_nilai;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "nimMahasiswa")
    private mahasiswaModel MahasiswaModel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kode_mk")
    private matkulModel MatakuliahModel;

    private Integer latihan;
    private Integer tugas;
    private Integer kuis;
    private Integer uts;
    private Integer uas;

    public Long getKd_nilai() {
        return kd_nilai;
    }

    public void setKd_nilai(Long kd_nilai) {
        this.kd_nilai = kd_nilai;
    }

    public mahasiswaModel getMahasiswaModel() {
        return MahasiswaModel;
    }

    public void setMahasiswaModel(mahasiswaModel MahasiswaModel) {
        this.MahasiswaModel = MahasiswaModel;
    }

    public matkulModel getMatakuliahModel() {
        return MatakuliahModel;
    }

    public void setMatakuliahModel(matkulModel MatakuliahModel) {
        this.MatakuliahModel = MatakuliahModel;
    }

    public Integer getLatihan() {
        return latihan;
    }

    public void setLatihan(Integer latihan) {
        this.latihan = latihan;
    }

    public Integer getTugas() {
        return tugas;
    }

    public void setTugas(Integer tugas) {
        this.tugas = tugas;
    }

    public Integer getKuis() {
        return kuis;
    }

    public void setKuis(Integer kuis) {
        this.kuis = kuis;
    }

    public Integer getUts() {
        return uts;
    }

    public void setUts(Integer uts) {
        this.uts = uts;
    }

    public Integer getUas() {
        return uas;
    }

    public void setUas(Integer uas) {
        this.uas = uas;
    }
}
