package org.jsp.springbootdemo.controller;

import org.jsp.springbootdemo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "Hello from Home Controller";
	}

	@RequestMapping("/test")
	public String test() {
		return "It is tested";
	}

	@PostMapping("/sum")
	public String getSum(@RequestParam int n1, @RequestParam int n2) {
		return "The sum is: " + (n1 + n2);
	}

	@GetMapping("/diff")
	public String getDiff(@RequestParam int n1, @RequestParam int n2) {
		return "The difference is: " + (n1 - n2);
	}

	@GetMapping("/even/{num}")
	public String evenOrOdd(@PathVariable(name = "num") int num) {
		return num % 2 == 0 ? num + " is an even number" : num + " is an odd number";
	}

	@GetMapping("/users")
	public User getUser() {
		return new User(1, "Md Saif Ali", 8809833242l, "mohammadsaifali09@gmail.com");
	}

	@PostMapping("/users")
	public String printUser(@RequestBody User user) {
		System.out.println("Id: " + user.getId());
		System.out.println("Name: " + user.getName());
		System.out.println("Phone: " + user.getPhone());
		System.out.println("Email: " + user.getEmail());
		System.out.println("-------------------------");
		return "The details are printed";
	}
}
