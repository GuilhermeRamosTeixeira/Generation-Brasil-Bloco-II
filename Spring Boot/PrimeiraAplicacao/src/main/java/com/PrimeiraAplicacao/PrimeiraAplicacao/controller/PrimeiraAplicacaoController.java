package com.PrimeiraAplicacao.PrimeiraAplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PrimeiraAplicacao")
public class PrimeiraAplicacaoController{

	@GetMapping
public String PrimAplic() {
		return " BsM: Persistência e Habilidade: Atenção aos detalhes!!!";
	}
}
