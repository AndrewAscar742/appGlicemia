package br.com.senac.appGlicemia.dtos.output;

import java.util.List;
import java.util.stream.Collectors;

import br.com.senac.appGlicemia.domain.User;

public record UserDTO(Long id, String nome, String email, String senha, String peso, String altura, List<GlicemiaDTO> medicoesGlicemia) {
	
	public UserDTO(User user) {
		this(user.getId(), user.getNome(), user.getEmail(), user.getSenha(), user.getPeso(), user.getAltura(),
				user.getMedicoesGlicemia().stream().map(GlicemiaDTO::new).collect(Collectors.toList()));
	}

}
