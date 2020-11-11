package com.example.crud.areasdocondominio.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@Table(name="morador")
public class Morador {

	
	private long id_morador;
	private String nome_morador;
	private String nome_edificio;
	private int apartamento;
	private String cpf;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_morador() {
		return id_morador;
	}
	public void setId_morador(long id) {
		this.id_morador=id;
		
	}
	
	@Column(name="nome_morador", nullable=false, unique=true)
	public String getNome_morador() {
		return nome_morador;
	}
	public void setNome_morador(String nome_morador) {
		this.nome_morador = nome_morador;
	}
	@Column(name="nome_edificio", nullable=false)
	public String getNome_edificio() {
		return nome_edificio;
	}
	public void setNome_edificio(String nome_edificio) {
		this.nome_edificio = nome_edificio;
	}
	@Column(name="apartamento", nullable=false)
	public int getApartamento() {
		return apartamento;
	}
	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}
	@Column(name="cpf", nullable=false, unique=true)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
