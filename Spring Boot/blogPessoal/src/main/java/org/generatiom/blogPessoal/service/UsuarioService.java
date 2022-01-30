package org.generatiom.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generatiom.blogPessoal.model.UserLogin;
import org.generatiom.blogPessoal.model.Usuario;
import org.generatiom.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}
public Optional<UserLogin> Logar(Optional<UserLogin> user ){
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	Optional<Usuario> Usuario = repository.findByUsuario(user.get().getUsuario());
	
	if(Usuario.isPresent()) {
		if(encoder.matches(user.get().getSenha(), Usuario.get().getSenha())) {
			
			String auth = user.get().getUsuario() + ":" + user.get().getSenha();
			byte[] encodedAuth  = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String (encodedAuth);
		
			user.get().setToken(authHeader);
			
			user.get().setNome(Usuario.get().getnome());
			
			return user;
		}
	}
	
	return null;	
}
}

