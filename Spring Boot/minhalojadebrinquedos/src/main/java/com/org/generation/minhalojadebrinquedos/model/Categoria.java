package com.org.generation.minhalojadebrinquedos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(max = 50, message = "O atributo Gênero aceita no máximo 50 caracteres.")
	private String genero;
	
	@Size(max = 150, message = "O atributo Descrição aceita no máximo 150 caracteres.")
	private String descricao;
	
	@NotBlank
	@Size(max = 30, message = "O atributo Estúdio aceita no máximo 30 caracteres.")
	private String estudio;
	
	//GETS E SETS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	
}
