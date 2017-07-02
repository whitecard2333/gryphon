package com.oraclecube.whitecard.core.data.config;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;

import java.util.Map;
import java.util.Properties;

/**
 * Actual JPA properties implementation {@link JpaProperties}
 * Created by zhouhu on 21/4/2017.
 */
public class LocalJpaProperties extends JpaProperties {
    public Properties map2Properties() {
        Properties properties = new Properties();
        Map<String, String> map = getProperties();
        for (String key : map.keySet()) {
            properties.setProperty(key, map.get(key));
        }
        if (!properties.containsKey("hibernate.show_sql")) {
            properties.put("hibernate.show_sql", isShowSql());
        }
        return properties;
    }
}
