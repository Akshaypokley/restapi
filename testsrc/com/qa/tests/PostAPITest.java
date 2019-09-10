package com.qa.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.Data.Users;
import com.qa.base.TestBase;
import com.qa.odps.RestClientWithPost;
import netscape.javascript.JSObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PostAPITest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    String APIUrl;
    String URL;
    CloseableHttpResponse closeableHttpResponse;
    @BeforeMethod
    public void settup()
    {
        testBase = new TestBase();
        serviceUrl = pro.getProperty("url");
        APIUrl = pro.getProperty("serviceUrl");
        URL = serviceUrl + APIUrl;
    }

    @Test
    public void PostTest() throws IOException {
        RestClientWithPost restClientWithPost=new RestClientWithPost();
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("Content-type","application/json");
        //We can used Jacksoon utilites to convert jave object into Json and Json into jave
        //used objectMapper interface to convert the JSON formate
        ObjectMapper objectMapper=new ObjectMapper();
        Users users=new Users("Akshay","IT0");
        //object conversion into JSON file

        objectMapper.writeValue(new File("F:\\IDEPROJECTS\\restapi\\src\\com\\qa\\Data\\Users.Json"),users);
        //object to Json i perticuler string
       String userJsonString= objectMapper.writeValueAsString(users);
        System.out.println(userJsonString);
      closeableHttpResponse=  restClientWithPost.postReq(URL,userJsonString,hashMap);

        //Status Code
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_201,"Invalid code");

        //Json String

          String responceString=   EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
            JSONObject jsonObjectresponce=new JSONObject(responceString);

         System.out.println(jsonObjectresponce);
            //json to java object conversion

        Users usersResponce=objectMapper.readValue(responceString,Users.class);
        System.out.println(usersResponce);
       Assert.assertTrue(users.getName().equals(usersResponce.getName()));

    }
}
