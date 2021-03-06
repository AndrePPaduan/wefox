package com.wefox.wefox.service;

import com.google.gson.Gson;
import com.wefox.wefox.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

@Service
public class ErrorServiceImpl implements ErrorService {

    Gson gson = new Gson();

    @Autowired
    private CreateHttpConnection httpConnection;


    @Override
    public Error logError(InputStream httpError) throws IOException {

        Error error = new Error();
        error.setDescription(httpError.toString());

        HttpURLConnection http = httpConnection.createHttpConnection("http://localhost:9000/log");
        String data = gson.toJson(error);
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);

        return error;
    }
}
