package br.com.senac.appGlicemia.service;

import java.util.List;

import br.com.senac.appGlicemia.dtos.input.PostGlicemiaDTO;
import br.com.senac.appGlicemia.dtos.output.GlicemiaDTO;

public interface GlicemiaService {

	List<GlicemiaDTO> findById(Long userID);

	GlicemiaDTO save(PostGlicemiaDTO postGlicemiaDTO, Long userID);

}
