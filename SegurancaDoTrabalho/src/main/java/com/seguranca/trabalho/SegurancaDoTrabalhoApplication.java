package com.seguranca.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SegurancaDoTrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurancaDoTrabalhoApplication.class, args);
	}

}
 