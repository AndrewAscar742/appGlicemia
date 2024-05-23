package br.com.senac.appGlicemia.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.appGlicemia.domain.User;
import br.com.senac.appGlicemia.dtos.input.LoginDTO;
import br.com.senac.appGlicemia.dtos.input.PutUsuarioDTO;
import br.com.senac.appGlicemia.dtos.output.UserDTO;
import br.com.senac.appGlicemia.repositories.UserRepository;
import br.com.senac.appGlicemia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO authenticate(LoginDTO loginDTO) {
		Optional<User> optionalUser = userRepository.login(loginDTO.email(), loginDTO.senha());
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			UserDTO userDTO = new UserDTO(user);
			return userDTO;
		}
		
		return null;
	}
	
	@Override
	public UserDTO atualizarDados(PutUsuarioDTO putUsuarioDTO, Long userID) {
		Optional<User> optionalUser = userRepository.findById(userID);
		
		if (optionalUser.isEmpty())
			return null;
		
		User user = optionalUser.get();
		user.setEmail(putUsuarioDTO.email());
		user.setAltura(user.getAltura());
		user.setPeso(putUsuarioDTO.peso());

		userRepository.save(user);
		return new UserDTO(user);

	}

}
