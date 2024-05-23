package br.com.senac.appGlicemia.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String peso;
	private String altura;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Glicemia> medicoesGlicemia = new ArrayList<Glicemia>();
	
	@Nullable
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Relatorio> relatorios = new ArrayList<Relatorio>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nome, String email, String senha, String peso, String altura) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.peso = peso;
		this.altura = altura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public List<Glicemia> getMedicoesGlicemia() {
		return medicoesGlicemia;
	}

	public void setMedicoesGlicemia(List<Glicemia> medicoesGlicemia) {
		this.medicoesGlicemia = medicoesGlicemia;
	}
	
	
}
