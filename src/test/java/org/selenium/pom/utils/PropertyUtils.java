package org.selenium.pom.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyloader(String filename){
        Properties properties=new Properties();
        BufferedReader bufferedReader;
        try {
            bufferedReader=new BufferedReader(new FileReader(filename));
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Unable to load properties");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unable to load file");
        }
        return properties;
    }
}
