package com.org.generation.projetogames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.generation.projetogames.model.UserLogin;
import com.org.generation.projetogames.model.Usuario;
import com.org.generation.projetogames.repository.UsuarioRepository;



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
				
				user.get().setNome(Usuario.get().getNome());
				
				return user;
			}
		}
		
		return null;	
	}
}
