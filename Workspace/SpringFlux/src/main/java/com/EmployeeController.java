package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

	@RequestMapping(value="fluxInfo",method=RequestMethod.GET)
	public Flux<String> getSimpleFluxMessage() {
		return Flux.just("Welcome to Spring MVC With WebFlux App!");
	}
}
