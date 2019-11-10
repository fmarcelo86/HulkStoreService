package com.todo1.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HulkStoreServiceApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(HulkStoreServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	}
}
