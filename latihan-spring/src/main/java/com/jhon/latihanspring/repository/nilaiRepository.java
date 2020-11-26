package com.jhon.latihanspring.repository;

import com.jhon.latihanspring.model.nilaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nilaiRepository extends JpaRepository<nilaiModel, String> {

}
