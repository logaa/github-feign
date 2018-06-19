package com.logaa.example.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@RestController
public class ClientController {

	private static final String APIBASEURL = "http://localhost";

	@GetMapping(value = "/user/{name}")
	public User getUserInfo(@PathVariable String name) {
		UserApi userApi = Feign.builder().client(new ApacheHttpClient()).encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder()).target(UserApi.class, APIBASEURL);
		return userApi.getByName(name);
	}
}
