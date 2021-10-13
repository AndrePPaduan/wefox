package com.wefox.wefox.service;

import java.io.IOException;
import java.io.InputStream;

public interface ErrorService {

    public InputStream logError(InputStream error) throws IOException;
}
