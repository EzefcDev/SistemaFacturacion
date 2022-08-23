package com.example.sistemafacturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SistemaFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaFacturacionApplication.class, args);
	}

	@GetMapping("/secured")
	public String secured(){
		return "Esta seguro";
	}

	@GetMapping("/public")
	public String pub(){
		return "Esto es publico";
	}
}
