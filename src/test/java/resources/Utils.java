package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.awt.print.Printable;
import java.io.*;
import java.util.Properties;

public class Utils {
    RequestSpecification req;
    public RequestSpecification requestSpecification() {
        PrintStream log;
        try {
            log = new PrintStream(new FileOutputStream("logs.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties";
        req = new RequestSpecBuilder().setBaseUri(getKeyValue("baseURL",filePath))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
        return req;
    }

    public static String getKeyValue(String key, String filePath) {
        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        String value = prop.getProperty(key);
        return value;
    }


}
