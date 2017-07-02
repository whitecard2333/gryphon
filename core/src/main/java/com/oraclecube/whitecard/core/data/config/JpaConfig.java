package com.oraclecube.whitecard.core.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouhu on 21/4/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.oraclecube.whitecard"},
        entityManagerFactoryRef = "LocalContainerEntityManagerFactoryBean",transactionManagerRef = "JpaTransactionManager",
        repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
@EnableTransactionManagement
public class JpaConfig {
    private static final String ENTITY_SCAN_PACKAGE_PREFIX = "com.oraclecube.whitecard.core.data.entity";

    @Bean
    @ConfigurationProperties(prefix = "gryphon.config.enableJpa")
    public EnableJpaConfig getEnableJpaConfig() {
        return new EnableJpaConfig();
    }

    @Bean(name = "localJpaProperties")
//    @Primary
    @ConfigurationProperties(prefix = "gryphon.core.jpa")
    public LocalJpaProperties getJpaProperties() {
        return new LocalJpaProperties();
    }

    /**
     * Entity manager
     * @param localJpaProperties
     * @param dataSource
     * @return
     */
    @Bean(name = "LocalContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("localJpaProperties") LocalJpaProperties localJpaProperties, @Qualifier("localDataSource") DataSource dataSource, EnableJpaConfig enableJpaConfig) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        //set DataSource
        entityManagerFactoryBean.setDataSource(dataSource);

        //set package scanning for class with @Entity
        String[] scanPackages = getEntityScanPackages(enableJpaConfig);
        entityManagerFactoryBean.setPackagesToScan(scanPackages);

        //set JpaVendorAdapter as HibernateJpaVendorAdapter
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        //set JpaDialect as HibernateJpaDialect
        JpaDialect jpaDialect = new HibernateJpaDialect();
        entityManagerFactoryBean.setJpaDialect(jpaDialect);

        //set JPA properties
        entityManagerFactoryBean.setJpaProperties(localJpaProperties.map2Properties());
        return entityManagerFactoryBean;
    }

    @Bean(name = "JpaTransactionManager")
    @Autowired
    @Qualifier("LocalContainerEntityManagerFactoryBean")
    public JpaTransactionManager jpaTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return jpaTransactionManager;
    }

    /**
     * PersistenceExceptionTranslationPostProcessor is a bean post processor
     * which adds an advisor to any bean annotated with Repository so that any
     * platform-specific exceptions are caught and then rethrown as one
     * Spring's unchecked data access exceptions (i.e. a subclass of
     * DataAccessException).
     *
     * @return
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private String[] getEntityScanPackages(EnableJpaConfig enableJpaConfig) {
        if (null != enableJpaConfig && null != enableJpaConfig.getMap()) {
            Map<String, Boolean> enableJpas = enableJpaConfig.getMap();
            List<String> enableJpaList = new ArrayList<>();
            enableJpas.keySet().stream().filter(enableJpas::get).forEach(key -> {
                if (key.equals("default")) {
                    enableJpaList.add(ENTITY_SCAN_PACKAGE_PREFIX + ".common");
                    enableJpaList.add(ENTITY_SCAN_PACKAGE_PREFIX + ".auth");
                } else if (key.equals("application")) {
                    enableJpaList.add(ENTITY_SCAN_PACKAGE_PREFIX + ".application");
                }
            });
            return enableJpaList.toArray(new String[enableJpaList.size()]);
        }
        return new String[0];
    }

    public static class EnableJpaConfig {
        private Map<String, Boolean> map = new HashMap<>();

        public Map<String, Boolean> getMap() {
            return map;
        }

        public void setMap(Map<String, Boolean> map) {
            this.map = map;
        }
    }
}
