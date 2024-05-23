package br.com.senac.appGlicemia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.appGlicemia.domain.Glicemia;

public interface GlicemiaRepository extends JpaRepository<Glicemia, Long>{

	List<Glicemia> findByUsuarioId(Long userID);

}
