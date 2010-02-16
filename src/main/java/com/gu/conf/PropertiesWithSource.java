package com.gu.conf;

import java.util.Properties;

class PropertiesWithSource {

    private Properties properties;
    private PropertiesSource source;

    PropertiesWithSource(Properties properties, PropertiesSource source) {
        this.properties = properties;
        this.source = source;
    }

    String getStringProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    PropertiesSource getSource() {
        return source;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t");
        stringBuilder.append(source.getDescription());
        stringBuilder.append("\n");

        for (String propertyName : properties.stringPropertyNames()) {
            stringBuilder.append("\t\t");
            stringBuilder.append(propertyName);
            stringBuilder.append(" : ");
            stringBuilder.append(properties.getProperty(propertyName));
            stringBuilder.append("\n");
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}