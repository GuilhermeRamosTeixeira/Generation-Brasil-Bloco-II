package org.generatiom.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generatiom.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/** 
	 * Método criado para checar se o usuário já existe no banco de dados
	 */ 
	public Optional<Usuario> findByUsuario(String usuario);

	/** 
	 * Método criado para a Sessão de testes
	 */ 
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
