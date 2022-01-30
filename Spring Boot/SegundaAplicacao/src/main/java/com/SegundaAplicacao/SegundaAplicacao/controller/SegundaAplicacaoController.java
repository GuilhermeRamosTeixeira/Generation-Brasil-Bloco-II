package com.SegundaAplicacao.SegundaAplicacao.controller;



	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/SegundaAplicacao")
	public class SegundaAplicacaoController {

		@GetMapping
	public String SegundaAplicacao() {
			return " Criar as minhas duas primeiras aplicações";
		}
	}