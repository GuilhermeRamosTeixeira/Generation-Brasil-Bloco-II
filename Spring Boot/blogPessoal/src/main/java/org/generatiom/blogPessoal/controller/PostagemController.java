package org.generatiom.blogPessoal.controller;

import java.util.List;

import org.generatiom.blogPessoal.model.PostagemModel;
import org.generatiom.blogPessoal.repository.PostagemRepository;
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

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PostagemController {

	@Autowired
	private PostagemRepository repository;
		
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
@GetMapping("/{id}")
public ResponseEntity<PostagemModel>GetByid(@PathVariable long id){
	return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}


@ GetMapping("/titulo/{titulo}")
public ResponseEntity<List<PostagemModel>>GetByTitulo(@PathVariable String titulo){
	return  ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
}

@PostMapping
public ResponseEntity<PostagemModel>Post(@RequestBody PostagemModel postagem){
	
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
}

@PutMapping
public ResponseEntity<PostagemModel> put (@RequestBody PostagemModel postagem){
	return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
}

@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	repository.deleteById(id);
}


}
