package com.example.crud.areasdocondominio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="reserva")
public class Reserva {
	
	private long id_reserva;
	private Date data;
	private String hora_inicio;
	private String hora_fim;
	private String observacao;
	
	
	
	
	private long id_morador;
	private long id_areas;
	

	@Column(name="id_morador", nullable=false)
	public long getId_morador() {
		return id_morador;
	}
	public void setId_morador(long id_morador) {
		this.id_morador = id_morador;
	}
	@Column(name="id_area", nullable=false)
	public long getId_areas() {
		return id_areas;
	}
	public void setId_areas(long id_areas) {
		this.id_areas = id_areas;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(long id) {
		this.id_reserva=id;
		
	}
	
	@Column(name="data", nullable=false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	@Column(name="hora_inicio", nullable=false)
	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	@Column(name="hora_fim", nullable=false)
	public String getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}
	@Column(name="observacao")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	
	

}
