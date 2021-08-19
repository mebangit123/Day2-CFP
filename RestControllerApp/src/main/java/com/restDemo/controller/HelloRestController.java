package com.restDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restDemo.model.User;

@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
	//Making a GET call
	@GetMapping(value = {"", "/", "/home"})
	public String sayHello() {
		return "Hello from BridgeLabz!!";
	}
	
	//Making a GET call by passing a query parameter.
	@RequestMapping(value = {"/query"}, method = RequestMethod.GET) 
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello " + name + "!";
	}		
	
	//Making a GET call by passing parameter as a Path Variable.
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello " + name + ":";
	}
	
	//Making a POST call
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + ":";
	}
	
	//Making a PUT call
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + ":";
	}
}