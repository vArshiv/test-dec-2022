package com.example.HelloWorldApplication1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class HelloWorldApplication1ApplicationTests {
	
	@Container
	public static PostgreSQLContainer container = new PostgreSQLContainer()
			.withUsername("Hello")
			.withPassword("World")
			.withDatabaseName("test");
	
	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry, String name) {
		registry.add("spring.datasource.url*", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.password", container::getUsername);
		
		
	}

	@Test
	void contextLoads() {System.out.println("Hello World");
	}

}
