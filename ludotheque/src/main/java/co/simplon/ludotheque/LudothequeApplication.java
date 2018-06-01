package co.simplon.ludotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"co.simplon.ludotheque.controller"})
public class LudothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LudothequeApplication.class, args);
	}
}
