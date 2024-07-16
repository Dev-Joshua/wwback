package com.woofwk.woofworkout;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.models.Message;
import com.woofwk.woofworkout.web.controllers.ConexionBD;

import org.springframework.web.bind.annotation.GetMapping;




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


	// @GetMapping("message")
	// public Message getMessage () {
	// 	return new Message(LocalDateTime.now(), "Hola mundo");
	// }

	@Bean
    public CommandLineRunner demo() {
        return (args) -> {
            conexionBD.connect();
        };
    }
	
}
