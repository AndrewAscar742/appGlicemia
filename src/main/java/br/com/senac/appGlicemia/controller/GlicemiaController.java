package br.com.senac.appGlicemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.appGlicemia.dtos.input.PostGlicemiaDTO;
import br.com.senac.appGlicemia.dtos.output.GlicemiaDTO;
import br.com.senac.appGlicemia.service.GlicemiaService;

@RestController
@RequestMapping("/glicemia")
public class GlicemiaController {
	
	@Autowired
	private GlicemiaService glicemiaService;
	
	@GetMapping("/user/{userID}")
	public ResponseEntity<List<GlicemiaDTO>> listByUserID(@PathVariable("userID") Long userID) {
		List<GlicemiaDTO> glicemias = glicemiaService.findById(userID);
		
		return ResponseEntity.ok(glicemias);
	}
	
	@PostMapping("/save/{userID}")
	public ResponseEntity<GlicemiaDTO> save(@RequestBody PostGlicemiaDTO postGlicemiaDTO, @PathVariable("userID") Long userID) {
		GlicemiaDTO glicemiaDTO = glicemiaService.save(postGlicemiaDTO, userID);
		
		return ResponseEntity.ok(glicemiaDTO);
	}
}
