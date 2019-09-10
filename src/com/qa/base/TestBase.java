package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public Properties pro;
    public int RESPONSE_STATUS_CODE_200=200;
    public int RESPONSE_STATUS_CODE_201=201;
    public int RESPONSE_STATUS_CODE_400=400;
    public int RESPONSE_STATUS_CODE_500=500;
    public int RESPONSE_STATUS_CODE_404=404;

    public TestBase(){
     try{
         pro =new Properties();
         FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/com/qa/config/config.properties");
         pro.load(fis);
     }catch (FileNotFoundException fne)
     {
         fne.printStackTrace();
     }
     catch (IOException ioe)
     {
         ioe.printStackTrace();
     }
    }
}
