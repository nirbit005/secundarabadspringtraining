package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Customer {

	@RequestMapping(value = "custMsg",produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String sayHello() {
		System.out.println("I Came Here");
		return "Welcome to Spring Rest Full Web Service";
	}
}
