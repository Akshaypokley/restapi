package com.qa.odps;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class validaterestAPI {

    //1.Get Method
    public CloseableHttpResponse get(String url) throws IOException {
        CloseableHttpClient CclientConnetion = HttpClients.createDefault(); //Create the clientConnetion
        HttpGet httpGet = new HttpGet(url); //FOR HTTPS GET REQUEST

        CloseableHttpResponse closeableHttpResponse=CclientConnetion.execute(httpGet);//HIT THE URL AND GET CLIENT RESPONSE

        return closeableHttpResponse;
    }
}
