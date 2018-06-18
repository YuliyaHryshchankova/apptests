package com.company.test.webservices.apachehttpclientexample.tests;

import com.company.test.webservices.apachehttpclientexample.utils.MyHttpClient;
import com.company.test.webservices.apachehttpclientexample.utils.WebServicesPreconditions;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PositiveTest extends WebServicesPreconditions {

    private static final String COUNTRY = "USA";
    private static final String STATE = "HI";

    @Test(description = "Verify 200 status code returned")
    public void test() throws IOException {

        HttpGet httpGet = new HttpGet(MyHttpClient.buildURL(URI, COUNTRY, STATE));

        CloseableHttpResponse response = client.execute(httpGet);

        System.out.println("Response status code is " + response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);
        Assert.assertTrue(result.toString().contains("State found matching code"));
    }
}
