package com.coforge.training.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Author : Pappula.Naidu
* Date   : 02-Dec-2024
* Time   : 3:28:10 pm
* Project Name :com.coforge.training.security.controller
**/

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	@GetMapping("/hello")
	public String name() {
		return "Hello World From Spring Security";
	}
}

