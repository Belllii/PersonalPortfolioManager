package com.portfolio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final HttpClient client =
            HttpClient.newHttpClient();

    private final ObjectMapper objectMapper =
            new ObjectMapper();

    public String fetchData() throws Exception {

        String url =
                "https://jsonplaceholder.typicode.com/todos/1";

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        String json = response.body();

        // Jackson JSON parsing
        JsonNode object =
                objectMapper.readTree(json);

        int userId =
                object.get("userId").asInt();

        int id =
                object.get("id").asInt();

        String title =
                object.get("title").asText();

        boolean completed =
                object.get("completed").asBoolean();

        return "User ID: " + userId
                + "\nID: " + id
                + "\nTitle: " + title
                + "\nCompleted: " + completed
                + "\n\nRaw JSON:\n"
                + json;
    }
}