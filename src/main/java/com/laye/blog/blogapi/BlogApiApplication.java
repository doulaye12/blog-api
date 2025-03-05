package com.laye.blog.blogapi;

import com.laye.blog.blogapi.models.Role;
import com.laye.blog.blogapi.models.User;
import com.laye.blog.blogapi.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepo userRepository) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword("admin");
				admin.setEmail("admin@admin.com");
				admin.setRole(Role.ADMIN);
				userRepository.save(admin);
				System.out.println("Admin added");
			}
		};
	}
}
