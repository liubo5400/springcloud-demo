package com.netease.house.springcloudopenfeignconsumer.web.controller;

import com.netease.house.springcloudopenfeignconsumer.remote.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign")
public class ConsumerController {

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/get1")
    public String testget1(){
        return testFeign.get1();
    }

    @GetMapping("/get2/{id}")
    public String testget2(@PathVariable("id") Long id){
        return testFeign.get2(id);
    }
    
}
