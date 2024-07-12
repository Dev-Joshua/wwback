package com.woofwk.woofworkout;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.models.Message;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class WoofworkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoofworkoutApplication.class, args);
		System.out.println("Staarted....");
	}


	@GetMapping("/api/message")
	public Message getMessage () {
		return new Message(LocalDateTime.now(), "Hola mundo");
	}
	
}
