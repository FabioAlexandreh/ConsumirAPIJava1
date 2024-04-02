package br.edu.fatecpg.to.api.Api.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// criamos o packege service e criamos a classe ConsomeAPI
public class ConsomeApi {
// utiliza o site java docs para baixar a dependencia httprequest e http response
    public String lerJson(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response;
// cria um try catch para arrumar o problema do response
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
