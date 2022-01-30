package org.generatiom.blogPessoal.controller;

import java.util.List;

import org.generatiom.blogPessoal.model.Tema;
import org.generatiom.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@RequestMapping("/tema")
	
public class TemaController {

		@Autowired
		public TemaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Tema>>getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
	@GetMapping(";{id}")
	public ResponseEntity<Tema>getByid(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>>getBynome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
@PostMapping
public ResponseEntity<Tema>post(@RequestBody Tema tema){
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	
}
@PutMapping
public ResponseEntity<Tema> put(@RequestBody Tema tema){
	return ResponseEntity.ok(repository.save(tema));
}

@DeleteMapping
public void delete (@PathVariable long id) {
	repository.deleteById(id);
}
}