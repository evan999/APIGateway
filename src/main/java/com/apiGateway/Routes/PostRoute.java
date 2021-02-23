package com.apiGateway.Routes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class PostRoute {

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
}
