package com.netease.house.springcloudopenfeignconsumer.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                // 连接超时
                .connectTimeout(20, TimeUnit.SECONDS)
                // 响应超时
                .readTimeout(20, TimeUnit.SECONDS)
                // 写超时
                .writeTimeout(20, TimeUnit.SECONDS)
                // 是否自动重连
                .retryOnConnectionFailure(true)
                // 连接池
                .connectionPool(new ConnectionPool())
                .build();
    }

}
