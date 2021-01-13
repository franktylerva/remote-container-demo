package com.example;

import com.example.person.domain.Person;
import com.example.person.domain.WriteRepository;

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
	ApplicationRunner init(WriteRepository repository) {
		return args -> {
			repository.createPerson( new Person(null, "Sally Ride") );
			repository.createPerson( new Person(null, "Neil Armstrong") );
			repository.createPerson( new Person(null, "Alan Shepard") );
		};
	}

}
