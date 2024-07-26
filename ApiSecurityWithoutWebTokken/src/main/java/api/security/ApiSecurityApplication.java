package api.security;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import api.security.entities.Nationality;
import api.security.repositories.INationalityRepository;

@SpringBootApplication
public class ApiSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(INationalityRepository nationality) {
		
		return args -> {
		
			Nationality nacion = new Nationality("chile","spanish");
			
			nationality.save(nacion);
		};
	}

}
