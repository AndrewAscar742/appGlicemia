package br.com.senac.appGlicemia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.senac.appGlicemia.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.senha = :senha")
	Optional<User> login(@Param("email") String email, @Param("senha") String senha);

}
