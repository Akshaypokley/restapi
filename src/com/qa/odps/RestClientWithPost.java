package com.qa.odps;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RestClientWithPost {

    public CloseableHttpResponse postReq(String URL, String entitystring, HashMap<String,String> hashMap) throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();//craete the client connection

        HttpPost httpPost=new HttpPost(URL);//post request

        httpPost.setEntity(new StringEntity(entitystring));//defing payload page

        //for hader
        for(Map.Entry<String,String> entry:hashMap.entrySet())
        {
         httpPost.addHeader(entry.getKey(),entry.getValue());
        }
            CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPost);
             return  closeableHttpResponse;
    }
}
