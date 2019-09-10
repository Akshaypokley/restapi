package com.qa.odps;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClientHeders {

    //Get methode without header
    public CloseableHttpResponse get(String url) throws IOException {
        CloseableHttpClient CclientConnetion = HttpClients.createDefault(); //Create the clientConnetion
        HttpGet httpGet = new HttpGet(url); //FOR HTTPS GET REQUEST

        CloseableHttpResponse closeableHttpResponse=CclientConnetion.execute(httpGet);//HIT THE URL AND GET CLIENT RESPONSE

        return closeableHttpResponse;
    }



    //Get methode with header
    public CloseableHttpResponse get(String url, HashMap<String  ,String> headermap) throws IOException {
        CloseableHttpClient CclientConnetion = HttpClients.createDefault(); //Create the clientConnetion
        HttpGet httpGet = new HttpGet(url); //FOR HTTPS GET REQUEST

        for(Map.Entry<String,String> entry:headermap.entrySet())
        {
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }


        CloseableHttpResponse closeableHttpResponse=CclientConnetion.execute(httpGet);//HIT THE URL AND GET CLIENT RESPONSE

        return closeableHttpResponse;
    }
}
