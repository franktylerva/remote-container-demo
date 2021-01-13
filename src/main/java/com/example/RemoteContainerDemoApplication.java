package com.example;

import com.example.person.adapters.db.PersonEntity;
import com.example.person.adapters.db.PersonRepository;

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
			repository.save( new PersonEntity("Sally Ride") );
			repository.save( new PersonEntity("Neil Armstrong") );
			repository.save( new PersonEntity("Alan Shepard") );
		};
	}

}
