package com.example.HelloWorldApplication1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/Hello-World")
	public String hello() {
		return "Hello World";
	}

}