package org.jcorbett.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class HelloworldApplication {

	@RequestMapping("/")
	public HelloWorldMessage home() {
		return new HelloWorldMessage("Hello World!");
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}


class HelloWorldMessage {
	private static Random Rand = new Random();

	private String message;
	private byte[] random;

	public HelloWorldMessage(String message) {
		this.message = message;
		this.random = new byte[16];
		HelloWorldMessage.Rand.nextBytes(this.random);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getRandom() {
		return random;
	}

	public void setRandom(byte[] random) {
		this.random = random;
	}
}
