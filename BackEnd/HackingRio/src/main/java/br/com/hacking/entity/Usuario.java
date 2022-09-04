package br.com.hacking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String sobrenome;
	
	@Column (nullable = false)
	private String email;
	
	@Column (nullable = false)
	private String telefone;
	
	@Column (nullable = false)
	private Integer idade;
	
	@Column (nullable = false)
	private String cpf;
	
	@OneToMany
	private List<Empresa> empresas;
	
	
//	@OneToMany
//	private List<Projeto> projetos;

	@OneToOne
	private Login login;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

//	public List<Projeto> getProjetos() {
//		return projetos;
//	}
//
//	public void setProjetos(List<Projeto> projetos) {
//		this.projetos = projetos;
//	}

	public Login getLogins() {
		return login;
	}

	public void setLogins(Login login) {
		this.login = login;
	}

	
	

	
}
