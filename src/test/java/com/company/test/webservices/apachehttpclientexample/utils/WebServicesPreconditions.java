package com.company.test.webservices.apachehttpclientexample.utils;

import com.company.test.utilities.CustomListener;
import com.company.test.utilities.ScreenshotUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(CustomListener.class)
public class WebServicesPreconditions {

    protected static final String URI = "http://services.groupkt.com/state/get";

    protected static CloseableHttpClient client;

    @BeforeSuite
        public void beforeMethod() {
        client = MyHttpClient.getInstance();
    }

    @AfterSuite
    public void afterMethod() throws IOException {
        if (client != null) {
            client.close();
        }
        client = null;
    }

    protected Logger logger = Logger.getLogger(getClass());

}
