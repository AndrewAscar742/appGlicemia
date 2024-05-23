package br.com.senac.appGlicemia.config;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.senac.appGlicemia.domain.Glicemia;
import br.com.senac.appGlicemia.domain.User;
import br.com.senac.appGlicemia.repositories.UserRepository;

@Configuration
@Scope
public class ApiConfig {
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public List<User> startDB() {
		User user1 = new User("Andrew", "andrewteste@fake.com", "123", "70", "1.70");
		User user2 = new User("Anne", "anneteste@fake.com", "123", "60", "1.60");
		User user3 = new User("André", "andreteste@fake.com", "123", "75", "1.75");
		
		Glicemia glicemia1 = new Glicemia(85f, LocalTime.now(), user1);
		Glicemia glicemia1_1 = new Glicemia(87f,  LocalTime.now(), user1);
		Glicemia glicemia1_2 = new Glicemia(90f,  LocalTime.now(), user1);
		List<Glicemia> listGlicemia1 = List.of(glicemia1, glicemia1_1, glicemia1_2);
		user1.setMedicoesGlicemia(listGlicemia1);
		
		Glicemia glicemia2 = new Glicemia(85f,  LocalTime.now(), user2);
		Glicemia glicemia2_1 = new Glicemia(87f,  LocalTime.now(), user2);
		Glicemia glicemia2_2 = new Glicemia(90f,  LocalTime.now(), user2);
		List<Glicemia> listGlicemia2 = List.of(glicemia2, glicemia2_1, glicemia2_2);
		user2.setMedicoesGlicemia(listGlicemia2);
		
		Glicemia glicemia3 = new Glicemia(85f,  LocalTime.now(), user3);
		Glicemia glicemia3_1 = new Glicemia(87f,  LocalTime.now(), user3);
		Glicemia glicemia3_2 = new Glicemia(90f,  LocalTime.now(), user3);
		List<Glicemia> listGlicemia3 = List.of(glicemia3, glicemia3_1, glicemia3_2);
		user3.setMedicoesGlicemia(listGlicemia3);
			
		return userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}
