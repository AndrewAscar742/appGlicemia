package br.com.senac.appGlicemia.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.senac.appGlicemia.dtos.input.PostGlicemiaDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Glicemia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float valorGlicemia;
	private LocalTime horario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User usuario;
	
	public Glicemia() {
		// TODO Auto-generated constructor stub
	}
	
	public Glicemia(Float valorGlicemia, LocalTime horario, User usuario) {
		super();
		this.valorGlicemia = valorGlicemia;
		this.horario = horario;
		this.usuario = usuario;
	}

	public Glicemia(PostGlicemiaDTO postGlicemiaDTO) {
		this.valorGlicemia = postGlicemiaDTO.valorGlicemia();
		this.horario = postGlicemiaDTO.dataHora();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValorGlicemia() {
		return valorGlicemia;
	}

	public void setValorGlicemia(Float valorGlicemia) {
		this.valorGlicemia = valorGlicemia;
	}

	public LocalTime getDataHora() {
		return horario;
	}

	public void setDataHora(LocalTime dataHora) {
		this.horario = dataHora;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
}
