package com.wengs.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EchoBrokerController {

	@MessageMapping("/echo")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		String name = message.getName();
		return new Greeting("Hello, " + name + "!");
	}

}

class Greeting {
	private String content;

	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}

class HelloMessage {
	private String name;

	public String getName() {
		return name;
	}
}
