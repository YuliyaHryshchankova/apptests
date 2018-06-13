package com.company.test.webservices.apachehttpclientexample.tests;

import com.company.test.webservices.apachehttpclientexample.utils.WebServicesPreconditions;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NegativeTest extends WebServicesPreconditions {

    private static final String URL = "http://services.groupkt.com/css/app.css";

    @Test(description = "Verify 404 status code returned")
    public void negativeTest() throws IOException {

        HttpGet httpPost = new HttpGet(URL);

        CloseableHttpResponse response = client.execute(httpPost);

        System.out.println("Response status code is " + response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
        System.out.println("Requested page is not found.");

        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);
        Assert.assertTrue(result.toString().contains("HTTP Status 404 – Not Found"));

    }
}
