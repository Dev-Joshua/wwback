package com.woofwk.woofworkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.web.controllers.ConexionBD;




@RestController
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class WoofworkoutApplication {

	@Autowired
	private ConexionBD conexionBD;

	public static void main(String[] args) {
		SpringApplication.run(WoofworkoutApplication.class, args);
		System.out.println("Staarted....");
	}

    
    @Bean
    CommandLineRunner demo() {
        return (args) -> {
            conexionBD.connect();
        };
    }
    
    // @GetMapping("message")
    // public Message getMessage () {
    // 	return new Message(LocalDateTime.now(), "Hola mundo");
    // }
	
}
