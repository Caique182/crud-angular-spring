package br.com.prova.Processos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class ProcessosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessosApplication.class, args);
	}

}
