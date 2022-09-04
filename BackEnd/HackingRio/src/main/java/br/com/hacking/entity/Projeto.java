package br.com.hacking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String descricao;

//	@ManyToOne
//	private Usuario usuarios;
	
	@ManyToOne
	private Empresa empresas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public Usuario getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(Usuario usuarios) {
//		this.usuarios = usuarios;
//	}

	public Empresa getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresa empresas) {
		this.empresas = empresas;
	}
	
	
	
	
}
