package org.generatiom.blogPessoal.repository;

import java.util.Optional;

import org.generatiom.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsuario(String usuario);
}
