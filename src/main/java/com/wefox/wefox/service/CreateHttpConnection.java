package com.wefox.wefox.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CreateHttpConnection {

    public HttpURLConnection createHttpConnection(String specificUrl) throws IOException {

        URL url = new URL(specificUrl);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");

        return http;
    }
}
