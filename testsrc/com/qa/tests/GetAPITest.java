package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.odps.Restclient;
import com.qa.odps.validaterestAPI;
import com.qa.util.Testutils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class GetAPITest extends TestBase {
TestBase testBase;
    String serviceUrl;
    String APIUrl;
    String URL;
    CloseableHttpResponse closeableHttpResponse;
    @BeforeMethod
    public void setUp() throws IOException {
    testBase=new TestBase();
    serviceUrl=pro.getProperty("url");
    APIUrl=pro.getProperty("serviceUrl");
    URL=serviceUrl+APIUrl;

    }

    @Test
    public void APItest() throws IOException {
        Restclient restclient=new Restclient();
        restclient.get(URL);


    }

    @Test
    public void ValidateAPItest() throws IOException {
        validaterestAPI validaterestAPI=new validaterestAPI();
        closeableHttpResponse= validaterestAPI.get(URL);

        //a.STATUS CODE
        int StatusCode=closeableHttpResponse.getStatusLine().getStatusCode();// GET THE STATUS CODE
        System.out.println(StatusCode);

        Assert.assertEquals(StatusCode,RESPONSE_STATUS_CODE_200,"Response code is not 200");
        //B.json strings
        String Response= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        JSONObject ResponsejsonObject=new JSONObject(Response);
        System.out.println(ResponsejsonObject);
//Single values
        String Perpagevalue=Testutils.getValueByJPath(ResponsejsonObject,"/per_page");
        System.out.println(Perpagevalue);
        Assert.assertEquals(Integer.parseInt(Perpagevalue),6);

    //Got the array of data

        String first_name=Testutils.getValueByJPath(ResponsejsonObject,"/data[0]/first_name");

        System.out.println(first_name);
        Assert.assertEquals(first_name,"George");
        //c.all headers
        Header[] headersArray=closeableHttpResponse.getAllHeaders();
        HashMap<String,String> Allheader=new HashMap<String, String>();

        for(Header header:headersArray)
        {
            Allheader.put(header.getName(),header.getValue());
            String hedertext=header.getName();

            Assert.assertEquals(hedertext,"Date","Heder text is not available ");

        }
        System.out.println("Header Array-->"+Allheader);

    }
}
