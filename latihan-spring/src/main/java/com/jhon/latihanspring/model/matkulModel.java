package com.jhon.latihanspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nilai")
public class matkulModel {
    @Id
    @Column(name = "kd_matkul")
    private Long kd_matkul;

    private String nm_matkul;
    private Double sks;

    public Long getKd_matkul() {
        return kd_matkul;
    }

    public void setKd_matkul(Long kd_matkul) {
        this.kd_matkul = kd_matkul;
    }

    public String getNm_matkul() {
        return nm_matkul;
    }

    public void setNm_matkul(String nm_matkul) {
        this.nm_matkul = nm_matkul;
    }

    public Double getSks() {
        return sks;
    }

    public void setSks(Double sks) {
        this.sks = sks;
    }
}
