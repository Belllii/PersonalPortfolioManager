package com.portfolio;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final HttpClient client =
            HttpClient.newHttpClient();

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

        JsonObject object =
                JsonParser.parseString(json)
                        .getAsJsonObject();

        int userId =
                object.get("userId").getAsInt();

        int id =
                object.get("id").getAsInt();

        String title =
                object.get("title").getAsString();

        boolean completed =
                object.get("completed").getAsBoolean();

        return "User ID: " + userId
                + "\nID: " + id
                + "\nTitle: " + title
                + "\nCompleted: " + completed
                + "\n\nRaw JSON:\n"
                + json;
    }
}