package br.com.senac.appGlicemia.dtos.input;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record PostGlicemiaDTO(Float valorGlicemia, @JsonFormat(pattern = "HH:mm") LocalTime dataHora) {

}
