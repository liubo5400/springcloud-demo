package com.netease.house.springcloudfeignconsumer.web.controller;

import com.netease.house.springcloudfeignconsumer.remote.TestFeign;
import feign.Feign;
import feign.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign")
public class ConsumerController {

    @GetMapping("/get1")
    public String testget1() {
        TestFeign target = Feign.builder().target(TestFeign.class, "http://localhost:8080");
        String result = target.get1();
        return result;
    }
}
