package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be respponsible for loading proporties file and willprovide access
    //to values based on key names
    private static Properties configFile;
    static{
        try {
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be executed
            //any class that is related to InputOutput produce checked exceptions
            //without handling checked exception, you cannot run a code
            FileInputStream fileInputStream=new FileInputStream("configuration.properties");
            configFile=new Properties();
            configFile.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("File was not loaded:(");
            e.printStackTrace();
        }
    }
public static String getProperty(String key){
        return configFile.getProperty(key);
}
}
