package com.jhon.latihanspring.repository;

import com.jhon.latihanspring.model.matkulModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface matkulRepository extends  JpaRepository<matkulModel,String>{


}
