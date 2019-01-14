package com.spring.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkapublisher")
public class PublisherController {

	private String TOPIC = "topicjan142";

	@Autowired
	private KafkaTemplate<String, Object> template;

	@GetMapping("/publishtest/{input}")
	public String publishTest(@PathVariable String input) {
		return "Data published"+input;
	}
	
	@GetMapping("/publish/{input}")
	public String publishMessage(@PathVariable String input) {
		template.send(TOPIC, "Hi  " + input + " welcome to Java Techie");
		return "Data published";
	}

	@GetMapping("/publishObject")
	public String publishJsonMessage() {
		template.send(TOPIC, new User(1234, "Basant Hota",
				new String[] { "Bangalore", "Marathali", "SGR Dental college", "house no : 143", "560037" }));
		return "Json Data published";
	}

}
