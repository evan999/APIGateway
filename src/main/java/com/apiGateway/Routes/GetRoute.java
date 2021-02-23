package com.apiGateway.Routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class GetRoute {

//    @Value("${url}")
//    private String url;
//    @GetMapping("/")
//    public String getRoute() throws IOException, InterruptedException{
//        HttpClient client = HttpClient.newHttpClient();
////				.version(HttpClient.Version.HTTP_1_1)
////				.followRedirects(HttpClient.Redirect.NORMAL)
////				.build();
//
//        //HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        //System.out.println(response.statusCode());
//        //System.out.println(response.body());
//
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", "application/json")
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        return response.body();
//    }
}
