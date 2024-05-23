package br.com.senac.appGlicemia.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private Boolean incluirPressaoSanguinea;
	private Boolean incluirMedicamentos;
	private Boolean incluirGlicemia;
	
	@ManyToOne()
	private User usuario;
	
	public Relatorio() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean getIncluirPressaoSanguinea() {
		return incluirPressaoSanguinea;
	}

	public void setIncluirPressaoSanguinea(Boolean incluirPressaoSanguinea) {
		this.incluirPressaoSanguinea = incluirPressaoSanguinea;
	}

	public Boolean getIncluirMedicamentos() {
		return incluirMedicamentos;
	}

	public void setIncluirMedicamentos(Boolean incluirMedicamentos) {
		this.incluirMedicamentos = incluirMedicamentos;
	}

	public Boolean getIncluirGlicemia() {
		return incluirGlicemia;
	}

	public void setIncluirGlicemia(Boolean incluirGlicemia) {
		this.incluirGlicemia = incluirGlicemia;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
}
