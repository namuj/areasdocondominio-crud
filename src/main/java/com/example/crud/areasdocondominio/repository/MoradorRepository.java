package com.example.crud.areasdocondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.example.crud.areasdocondominio.model.Areas;
import com.example.crud.areasdocondominio.model.Morador;


@Repository
public interface  MoradorRepository extends JpaRepository<Morador,Long> {

}
