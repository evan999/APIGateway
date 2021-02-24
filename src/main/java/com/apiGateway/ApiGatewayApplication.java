package com.apiGateway;

import com.apiGateway.Routes.GetRoute;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

	//private static final String POSTS_API_URL = "";
	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(ApiGatewayApplication.class, args);
//		GetRoute route = new GetRoute();
//		route.getRoute();
	}

	@Value("${url}")
	private String url;
	@GetMapping("/")
	public String getRoute() throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();


		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}
}
