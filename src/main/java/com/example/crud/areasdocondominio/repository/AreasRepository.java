package com.example.crud.areasdocondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.crud.areasdocondominio.model.Areas;

@Repository
public interface AreasRepository extends JpaRepository<Areas,Long> {

}
