package com.example.demoamqt;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DemoAmqtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAmqtApplication.class, args);
	}

}
