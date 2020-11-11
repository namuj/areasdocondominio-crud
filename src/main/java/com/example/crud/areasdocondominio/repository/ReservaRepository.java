package com.example.crud.areasdocondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.areasdocondominio.model.Morador;
import com.example.crud.areasdocondominio.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>  {

}
