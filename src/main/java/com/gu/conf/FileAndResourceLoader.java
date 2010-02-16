package com.gu.conf;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class FileAndResourceLoader {

    public InputStream getFile(String filename) throws IOException {
        return new BufferedInputStream(new FileInputStream(filename));
    }

    public InputStream getResource(String resource) throws IOException {
        ClassLoader classloader = FileAndResourceLoader.class.getClassLoader();
        URL url = classloader.getResource(resource);

        return new BufferedInputStream(url.openStream());
    }

    public Properties getPropertiesFromFile(String filename) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = getFile(filename);
            properties.load(inputStream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return properties;
    }

    public Properties getPropertiesFromResource(String resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = getResource(resource);
            properties.load(inputStream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return properties;
    }
}