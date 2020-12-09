package com.apiGateway;

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
	public static void main(String[] args) {


//		HttpClient client = HttpClient.newHttpClient();
////				.version(HttpClient.Version.HTTP_1_1)
////				.followRedirects(HttpClient.Redirect.NORMAL)
////				.build();
//
//		//HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//		//System.out.println(response.statusCode());
//		//System.out.println(response.body());
//
//
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://newsapi.org/v2/sources?apiKey=38b94640783949fd971bc7b04f93226a"))
//				.header("Content-Type", "application/json")
//				.GET()
//				.build();
//		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		/*
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println);

		 */
		/*
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("Content-Type", "application/json")
				.uri(URI.create(POSTS_API_URL))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
		 */



		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Value("${url}")
	private String url;
	@GetMapping("/")
	public String getRoute() throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();
//				.version(HttpClient.Version.HTTP_1_1)
//				.followRedirects(HttpClient.Redirect.NORMAL)
//				.build();

		//HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.statusCode());
		//System.out.println(response.body());


		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

//	@Value("${postUrl}")
//	private String postUrl;
	@PostMapping(path = "/posts", consumes = "application/json", produces = "application/json")
	public String postRoute(@RequestBody String request) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(request);
//				.version(HttpClient.Version.HTTP_1_1)
//				.followRedirects(HttpClient.Redirect.NORMAL)
//				.build();

		//HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.statusCode());
		//System.out.println(response.body());


		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://jsonplaceholder.typicode.com/posts"))
				.header("Content-Type", "application/json")
				.POST(body)
				.build();
		HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

//
//	@GetMapping("/post")
//	public Object postRoute(@RequestBody String request, @PathVariable String location) throws Exception, IOException{
//
//		HttpClient httpClient = HttpClient.newHttpClient();
//		HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(request);
//
//		HttpRequest serverRequest = HttpRequest.newBuilder()
//				.POST(body)
//				.header("Content-Type", "application/json")
//				.uri(URI.create(POSTS_API_URL))
//				.build();
//		HttpResponse<String> response = httpClient.send(serverRequest, HttpResponse.BodyHandlers.ofString());
//
//		return response.body();

//	}

}
