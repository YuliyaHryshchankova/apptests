package com.company.test.webservices.apachehttpclientexample.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class WebServicesPreconditions {

    protected static CloseableHttpClient client;

    @BeforeSuite
        public void beforeMethod() {
        client = HttpClient.getInstance();
    }

    @AfterSuite
    public void afterMethod() throws IOException {
        if (client != null) {
            client.close();
        }
        client = null;
    }

}
