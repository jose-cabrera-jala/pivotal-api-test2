package org.fundacionjala.pivotalapi.util;

import org.apache.log4j.Logger;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by AngelaValdez on 8/31/2016.
 */
public final class Environment {
    private static final Logger LOGGER = Logger.getLogger(Environment.class.getSimpleName());

    private static Environment instance;
    private static final Properties propertie = new Properties();
    private static final String FILENAME = "pivotal.properties";
    private Environment() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            propertie.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e.getCause());
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e.getCause());
        }

    }

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    public String getBaseURI() {
        return propertie.getProperty("baseURI");
    }

    public String getProxy() {
        return propertie.getProperty("proxy");
    }

    public String getUser() {
        return propertie.getProperty("user");
    }

    public String getPassword() {
        return propertie.getProperty("password");
    }

    public String getToken() {
        return propertie.getProperty("token");
    }

}
