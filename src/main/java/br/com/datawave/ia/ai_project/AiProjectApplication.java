package br.com.datawave.ia.ai_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiProjectApplication.class, args);
	}

}
