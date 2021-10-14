package com.wefox.wefox.service;

import com.wefox.wefox.model.Error;

import java.io.IOException;
import java.io.InputStream;

public interface ErrorService {

    public Error logError(InputStream error) throws IOException;
}
