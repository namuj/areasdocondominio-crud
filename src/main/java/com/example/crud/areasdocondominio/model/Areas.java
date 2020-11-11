package com.example.crud.areasdocondominio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
@Table(name="areas")
public class Areas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_areas;
	
	@Column(name="nome", nullable=false, unique=true)
	private String nome;
	


	

	


	
	public Areas() {
		
	}
	
	
	public Areas(long id, String nome) {
		
		this.id_areas = id;
		this.nome =nome;
	}
	
	
	public long getId_areas() {
		return id_areas;
	}
	public void setId_areas(long id) {
		this.id_areas=id;
		
	}

	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	


	
	@Override
	public String toString() {
		return "Areas [id_areas="+id_areas+",nome="+nome+"]";
	}
}
