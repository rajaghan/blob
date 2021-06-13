package com.jar.blob.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
	@GetMapping(path="/error/page")
	public String error() {
		return "ERROR";
	}
}
