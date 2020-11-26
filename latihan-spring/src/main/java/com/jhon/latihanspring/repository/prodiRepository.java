package com.jhon.latihanspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jhon.latihanspring.model.prodiModel;

import java.util.List;

@Repository
public interface prodiRepository extends JpaRepository<prodiModel, String> {
    @Query(value = "SELECT e.* FROM department e WHERE e.name LIKE '%?1%'", nativeQuery = true)
    List<prodiModel> searchByName(String name);
}
