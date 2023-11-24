package com.cinevibe;

import com.cinevibe.models.subclass.Customer;
import com.cinevibe.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository) {
		return (args) -> {
			Customer customer1 = new Customer("John Doe", "john.doe@example.com", "123456789", "pass123", LocalDate.of(1990, 1, 1), LocalDate.now(), true);
			userRepository.save(customer1);
		};
	}
}
