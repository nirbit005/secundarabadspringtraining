package com;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

public class FluxClientDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebClient client = WebClient.create("http://localhost:8080/fluxInfo");
		Flux<String> str = client.get().retrieve().bodyToFlux(String.class);
		str.subscribe(data->System.out.println(data));
		System.out.println("Normal Statement");
		Thread.sleep(5000);
	}

}
