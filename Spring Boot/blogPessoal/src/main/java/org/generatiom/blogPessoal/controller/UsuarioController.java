package org.generatiom.blogPessoal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.generatiom.blogPessoal.model.UserLogin;
import org.generatiom.blogPessoal.model.Usuario;
import org.generatiom.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin>Autentication(@RequestBody Optional<UserLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	


	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {

		return usuarioService.cadastrarUsuario(usuario)
			.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
}

}