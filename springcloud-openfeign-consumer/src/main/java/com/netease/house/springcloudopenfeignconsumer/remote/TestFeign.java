package com.netease.house.springcloudopenfeignconsumer.remote;

import com.netease.house.springcloudopenfeignconsumer.config.FeignConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "springcloud-provider", fallback = DefaultFailback.class)
public interface TestFeign {

    @GetMapping("/api/get1")
    String get1();

    @RequestMapping(value = "/api/get2/{id}", method = RequestMethod.GET)
    String get2(@PathVariable("id") Long id);

//    @RequestLine("GET /api/get1")
//    String get1();
//
//    @RequestLine("GET /api/get2/{id}")
//    String get2(@Param("id") Long id);




}
