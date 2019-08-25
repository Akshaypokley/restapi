package com.qa.odps;

import netscape.javascript.JSObject;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;

public class Restclient {

    //1.Get Method
    public void get(String url) throws IOException {
        CloseableHttpClient CclientConnetion = HttpClients.createDefault(); //Create the clientConnetion
        HttpGet httpGet = new HttpGet(url); //FOR HTTPS GET REQUEST

        CloseableHttpResponse closeableHttpResponse=CclientConnetion.execute(httpGet);//HIT THE URL AND GET CLIENT RESPONSE
        //a.STATUS CODE
        int StatusCode=closeableHttpResponse.getStatusLine().getStatusCode();// GET THE STATUS CODE
        System.out.println(StatusCode);
        //B.json strings
        String Response= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        JSONObject ResponsejsonObject=new JSONObject(Response);
        System.out.println(ResponsejsonObject);
        //c.all headers
        Header [] headersArray=closeableHttpResponse.getAllHeaders();
        HashMap<String,String> Allheader=new HashMap<String, String>();

        for(Header header:headersArray)
        {
            Allheader.put(header.getName(),header.getValue());
        }
        System.out.println("Header Array-->"+Allheader);


    }
}
