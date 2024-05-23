package br.com.senac.appGlicemia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.appGlicemia.dtos.input.LoginDTO;
import br.com.senac.appGlicemia.dtos.input.PutUsuarioDTO;
import br.com.senac.appGlicemia.dtos.output.UserDTO;
import br.com.senac.appGlicemia.service.UserService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserDTO> logarUsuario(@RequestBody LoginDTO loginDTO) {
		UserDTO userDTO = userService.authenticate(loginDTO);
		
		if (userDTO == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		else
			return ResponseEntity.ok(userDTO);
	}
	
	@PutMapping("/atualizar/{userID}")
	public ResponseEntity<UserDTO> atualizarDados(@RequestBody PutUsuarioDTO putUsuarioDTO, @PathVariable("userID") Long userID) {
		UserDTO userDTO = userService.atualizarDados(putUsuarioDTO, userID);
		
		if (userDTO == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(userDTO);
	}
}
