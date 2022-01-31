package com.org.generation.projetogames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

	@Entity
	@Table(name = "tb_usuario")
public class Usuario {

	
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message ="Atributo nome obrigatorio ")
		@Size(max =100 , message ="atributo nome aceita no maximo 100 caracteres")
		private String nome;
		
		@NotBlank(message = " atributo usuario é obrigatório!!!")
		@Size(max = 100 , message =" Atributo usuario aceita no maximo 100 caracteres")
		private String usuario;
		
		@NotBlank(message =" atributo senha é obrigatório!!!")
		@Size(max = 100 , message ="Atributo senha aceita no maximo 100 caracteres")
		private String senha;
		
		//GETS E SETS

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		
		
	}
