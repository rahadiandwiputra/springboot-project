package com.jhon.latihanspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "mahasiswa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class mahasiswaModel {
    @Id
    @Column(name = "nim")
    private Long nim;

    private String name;
    private String kelas;
    private String semester;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "prodi_id")
    private prodiModel ProdiModel;



    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public prodiModel getProdiModel() {
        return ProdiModel;
    }

    public void setProdiModel(prodiModel ProdiMode) {
        this.ProdiModel = ProdiModel;
    }


}
