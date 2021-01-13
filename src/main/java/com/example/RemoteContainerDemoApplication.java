package com.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RemoteContainerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteContainerDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PersonRepository repository) {
		return args -> {
			repository.save( new Person("Sally Ride") );
			repository.save( new Person("Neil Armstrong") );
			repository.save( new Person("Alan Shepard") );
		};
	}

}
