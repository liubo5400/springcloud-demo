package com.netease.house.springcloudprovider.web.controller;

import com.netease.house.springcloudprovider.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/get1")
    public String get1() {
        log.info("provider:get1");
        return "provider:get1";
    }

    @GetMapping("/get2/{id}")
    public String get2(@PathVariable(value = "id") Long id) {
        log.info("provider:get2:id:" + id);
        return "provider:get2:id:" + id;
    }

    @GetMapping("/get3")
    public User get3() {
        return User.builder().name("provider:user").mobile("13600000000").build();
    }

    @GetMapping("/get4")
    public String get4(@RequestHeader(value = "token") String token) {
        return "provider:get4:token:" + token;
    }

    @PostMapping("/post1")
    public String post1(@RequestBody User user) {
        return "provider:post1:user:name:" + user.getName() + ":mobile:" + user.getMobile();
    }

    @PostMapping("/post2")
    public String post2(@RequestHeader(value = "token") String token,
                        @RequestBody User user) {
        return "provider:post2:token:" + token + ":user:name:" + user.getName() + ":mobile:" + user.getMobile();
    }

    @PostMapping("/post3")
    public String post3(String name,String mobile) {
        return "provider:post3:user:name:" + name + ":mobile:" + mobile;
    }

    @PostMapping("/post4")
    public String post4(User user) {
        return "provider:post4:user:name:" + user.getName() + ":mobile:" + user.getMobile();
    }

    @PutMapping("/put1")
    public String put1(@RequestHeader(value = "token") String token,
                        @RequestBody User user) {
        return "provider:put1:token:" + token + ":user:name:" + user.getName() + ":mobile:" + user.getMobile();
    }

    @DeleteMapping("/del1/{id}")
    public String del1(@PathVariable(value = "id") Long id) {
        return "provider:put1:id:" + id;
    }
}
