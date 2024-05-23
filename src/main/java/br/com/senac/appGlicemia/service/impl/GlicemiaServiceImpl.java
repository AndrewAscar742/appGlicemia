package br.com.senac.appGlicemia.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.appGlicemia.domain.Glicemia;
import br.com.senac.appGlicemia.dtos.input.PostGlicemiaDTO;
import br.com.senac.appGlicemia.dtos.output.GlicemiaDTO;
import br.com.senac.appGlicemia.repositories.GlicemiaRepository;
import br.com.senac.appGlicemia.repositories.UserRepository;
import br.com.senac.appGlicemia.service.GlicemiaService;

@Service
public class GlicemiaServiceImpl implements GlicemiaService{
	
	@Autowired
	private GlicemiaRepository glicemiaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<GlicemiaDTO> findById(Long userID) {
		 List<Glicemia> glicemias = glicemiaRepository.findByUsuarioId(userID);
		
		return glicemias.stream().map(GlicemiaDTO::new).collect(Collectors.toList());
	}

	@Override
	public GlicemiaDTO save(PostGlicemiaDTO postGlicemiaDTO, Long userID) {
		Glicemia glicemia = new Glicemia(postGlicemiaDTO);
		glicemia.setUsuario(userRepository.findById(userID).get());
		glicemiaRepository.save(glicemia);
		
		return new GlicemiaDTO(glicemia);
		
	}
}
