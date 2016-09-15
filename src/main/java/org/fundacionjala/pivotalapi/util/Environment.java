package org.fundacionjala.pivotalapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by AngelaValdez on 8/31/2016.
 */
public class Environment {
    private static Environment instance;
    private static final Properties prop = new Properties();
    private static final String FILENAME = "config.properties";
    private Environment() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    public String getBaseURI() {
        return prop.getProperty("baseURI");
    }

    public String getProxy() {
        return prop.getProperty("proxy");
    }

    public String getUser() {
        return prop.getProperty("user");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getToken() {
        return prop.getProperty("token");
    }

}
