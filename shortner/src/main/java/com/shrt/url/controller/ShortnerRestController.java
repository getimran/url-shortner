package com.shrt.url.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortnerRestController {

	@GetMapping("/rest")
	public String init() {
		return "Appilcation is Running..";		
	}
	
}
