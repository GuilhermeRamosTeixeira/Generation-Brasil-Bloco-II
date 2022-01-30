package com.org.generation.minhalojadebrinquedos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.generation.minhalojadebrinquedos.model.Categoria;
import com.org.generation.minhalojadebrinquedos.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository categoriarepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategoriaAll(){
		return ResponseEntity.ok(categoriarepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getByCategoriaId(@PathVariable long id){
		return categoriarepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
		
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByCategoriaDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriarepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriarepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria){
		return categoriarepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.ok().body(categoriarepository.save(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable long id){
		return categoriarepository.findById(id).map(resposta ->{
			categoriarepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
