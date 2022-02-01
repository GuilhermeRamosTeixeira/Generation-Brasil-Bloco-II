package org.generatiom.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generatiom.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0, "João da Silva", "joao@email.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0, "Manuela da Silva", "manuela@email.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0, "Adriana da Silva", "adriana@email.com.br", "13465278"));

        usuarioRepository.save(new Usuario(0, "Paulo Antunes", "paulo@email.com.br", "13465278"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getnome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getnome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getnome().equals("Adriana da Silva"));
		
	}

}