package com.tam.utility.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    FileInputStream fis;
    Properties p;

    public ReadProperties(String fileName){

        try {
            this.fis = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\test\\resources\\Config\\" + fileName + ".properties");
            this.p = new Properties();
            this.p.load(fis);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getPropValue(String propName){
        return p.getProperty(propName);
    }
}
