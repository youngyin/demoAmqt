package com.example.demoamqt;

import org.springframework.boot.SpringApplication;

public class TestDemoAmqtApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoAmqtApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
