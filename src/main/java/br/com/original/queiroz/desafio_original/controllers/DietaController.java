package br.com.original.queiroz.desafio_original.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.original.queiroz.desafio_original.presenters.Dieta;
import br.com.original.queiroz.desafio_original.repositories.DietaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "dieta", produces = MediaType.APPLICATION_JSON_VALUE)

public class DietaController {
	
	@Autowired
	private DietaRepository dietaRepository; 
	
	@ApiOperation(value = "busca dados básicos simulação")
    @GetMapping(path = "")
    public ResponseEntity<List<Dieta>> buscar() {
		
		
		var all = dietaRepository.getAll(); 
		if(all==null ||all.isEmpty()) {
			return new ResponseEntity<List<Dieta>>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(all); 	 
	}
	
	@GetMapping(path = "{id}")
    public ResponseEntity<Dieta> buscarDietaUnica(
    		@PathVariable (name = "id", required = true) Integer id) {
		
		var item = dietaRepository.findById(id);
		
		if(item.isEmpty()) {
			return new ResponseEntity<Dieta>(HttpStatus.NOT_FOUND); 
		}
		
		
		return ResponseEntity.ok(item.get());  	 
	}
	
	@PostMapping(path = "/dieta")
	public ResponseEntity<Integer> adicionaDieta(@RequestBody Dieta dieta) throws URISyntaxException {
		
		var item = dietaRepository.save(dieta);
		
		return new ResponseEntity<Integer>(item.getCodigo(), HttpStatus.CREATED); 
		
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Integer> deletaDieta(@PathVariable("id") Integer id) {
	
		var item = dietaRepository.findById(id);
		
		if(item.isEmpty()) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		}
		
		dietaRepository.delete(id);
		
		return ResponseEntity.ok(id); 
	}
	
	
	@PutMapping(path = "{id}")
	public ResponseEntity<Integer> adicionaDieta(@PathVariable("id") Integer id, 
			@RequestBody Dieta dieta) throws URISyntaxException {
		
		var item = dietaRepository.findById(id);
		
		if(item.isEmpty()) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		}
		
		
		var item2 = dietaRepository.save(dieta);
		
		return new ResponseEntity<Integer>(item2.getCodigo(), HttpStatus.OK); 
		
	}
}
