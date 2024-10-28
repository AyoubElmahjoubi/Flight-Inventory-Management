package com.Demo.Flight_Inventory_Management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.cache.CacheManager;
import java.util.Collections;

@Configuration
public class CachConfig {

    @Bean
    public CacheManagerCustomizers cacheManagerCustomizers() {
        return new CacheManagerCustomizers(Collections.emptyList());
    }

}
