package br.com.senac.appGlicemia.service;

import br.com.senac.appGlicemia.dtos.input.LoginDTO;
import br.com.senac.appGlicemia.dtos.input.PutUsuarioDTO;
import br.com.senac.appGlicemia.dtos.output.UserDTO;

public interface UserService {

	UserDTO authenticate(LoginDTO loginDTO);

	UserDTO atualizarDados(PutUsuarioDTO putUsuarioDTO, Long userID);

}
