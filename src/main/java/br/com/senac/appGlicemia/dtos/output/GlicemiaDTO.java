package br.com.senac.appGlicemia.dtos.output;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.appGlicemia.domain.Glicemia;

public record GlicemiaDTO(Long id, Float valorGlicemia, @JsonFormat(pattern = "HH:mm") LocalTime dataHora) {
	
	public GlicemiaDTO(Glicemia glicemia) {
		this(glicemia.getId(), glicemia.getValorGlicemia(), glicemia.getDataHora());
	}
}
