package com.company.test.webservices.apachehttpclientexample.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MyHttpClient {

    protected static CloseableHttpClient client;

    public static CloseableHttpClient getInstance() {
        if (null == client) {
            client = HttpClients.createDefault();
        }
        return client;
    }

    public static String buildURL(String uri, String country, String state) {
        return uri + "/" + country + "/" + state;
    }

}
