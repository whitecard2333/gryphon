package com.oraclecube.whitecard.core.data.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

/**
 * Actual DataSourceProperties implementation {@link DataSourceProperties}
 * Add some properties used in DataSource pool
 * Created by zhouhu on 21/4/2017.
 */
public class LocalDataSourceProperties extends DataSourceProperties {
    private int initialSize;
    private int maxActive;
    private long maxWaitMillis;

    public int getInitialSize() {
        if (initialSize <= 0) {
            initialSize = 10;
        }
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        if (maxActive <= 0) {
            maxActive = 10;
        }
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public long getMaxWaitMillis() {
        if (maxWaitMillis <= 0L) {
            maxWaitMillis = 5000L;
        }
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
