package com.jhon.latihanspring.DTO;

import com.jhon.latihanspring.model.prodiModel;

import javax.validation.constraints.NotNull;
public class MahasiswaDTO {
    public static class Response{
        private String nimMahasiswa;
        private String nameMahasiswa;
        private String kelasMahasiswa;
        private String semesterMahasiswa;

        public String getNimMahasiswa() {
            return nimMahasiswa;
        }

        public void setNimMahasiswa(String nimMahasiswa) {
            this.nimMahasiswa = nimMahasiswa;
        }

        public String getNameMahasiswa() {
            return nameMahasiswa;
        }

        public void setNameMahasiswa(String nameMahasiswa) {
            this.nameMahasiswa = nameMahasiswa;
        }

        public String getKelasMahasiswa() {
            return kelasMahasiswa;
        }

        public void setKelasMahasiswa(String kelasMahasiswa) {
            this.kelasMahasiswa = kelasMahasiswa;
        }

        public String getSemesterMahasiswa() {
            return semesterMahasiswa;
        }

        public void setSemesterMahasiswa(String semesterMahasiswa) {
            this.semesterMahasiswa = semesterMahasiswa;
        }
    }
    public static class Request{
        @NotNull(message="NIM Tidak Boleh Kosong")
        private String nim;

        @NotNull
        private String name;
        @NotNull
        private String kelas;
        @NotNull
        private String semester;
        @NotNull
        private prodiModel ProdiModel;
        private String jumlah;

        public Request(@NotNull(message = "NIM Tidak Boleh Kosong") String nim, @NotNull String name, @NotNull String kelas, @NotNull String semester, @NotNull prodiModel prodiModel) {
            this.nim = nim;
            this.name = name;
            this.kelas = kelas;
            this.semester = semester;

            ProdiModel = prodiModel;
        }

        public String toString(){
            return "jumlah: "+this.jumlah+ "\n" + "kelas: "+this.kelas;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
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

        public void setProdiModel(prodiModel prodiModel) {
            ProdiModel = prodiModel;
        }
    }
}
