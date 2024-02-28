package com.example.PPSIntershipRESTapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PpsIntershipResTapiApplication {
	public String PORT = System.getenv("PORT");
	public String DATABASE_URL = System.getenv("DATABASE_URL");
	public static void main(String[] args) {
		SpringApplication.run(PpsIntershipResTapiApplication.class, args);
	}

}
