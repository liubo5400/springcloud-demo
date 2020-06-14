package com.netease.house.springcloudresttemplateconsumer.web.controller;

import com.netease.house.springcloudresttemplateconsumer.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    @RequestMapping("/test1")
    public String test1(){
//        RestTemplate restTemplate = new RestTemplate();
//        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        String url = "http://localhost:8080/api/";

        //1. 简单Get请求
        String result = restTemplate.getForObject(url + "get1?params=get1", String.class);
        log.info("简单Get请求:" + result);

        //2. 简单带路径变量参数Get请求
        result = restTemplate.getForObject(url + "get2/{1}", String.class, 111);
        log.info("简单带路径变量参数Get请求:" + result);

        //3. 返回对象Get请求
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url + "get3", User.class);
        log.info("返回:" + responseEntity);
        log.info("返回对象Get请求:" + responseEntity.getBody());

        //4. 设置header的Get请求
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "123");
        ResponseEntity<String> response = restTemplate.exchange(url + "get4", HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        log.info("设置header的Get请求:" + response.getBody());

        //5. Post对象
        User user = User.builder().name("TEST").mobile("18911111111").build();

        MultiValueMap<String,Object> params = new LinkedMultiValueMap<String,Object>();
        params.add("name","aaaa");
        params.add("mobile","18611111111");


        result = restTemplate.postForObject(url + "post1", user, String.class);
        log.info("Post1对象:" + result);


        result = restTemplate.postForObject(url + "post3",  params, String.class);
        log.info("Post3对象:" + result);

        result = restTemplate.postForObject(url + "post4",  user, String.class);
        log.info("Post4对象:" + result);

        //6. 带header的Post数据请求
        response = restTemplate.postForEntity(url + "post2", new HttpEntity<User>(user, headers), String.class);
        log.info("带header的Post数据请求:" + response.getBody());

        //7. 带header的Put数据请求
        //无返回值
        restTemplate.put(url + "put1", new HttpEntity<User>(user, headers));
        //带返回值
        response = restTemplate.exchange(url + "put1", HttpMethod.PUT, new HttpEntity<User>(user, headers), String.class);
        log.info("带header的Put数据请求:" + response.getBody());

        //8. del请求
        //无返回值
        restTemplate.delete(url + "del1/{1}", 332);
        //带返回值
        response = restTemplate.exchange(url + "del1/332", HttpMethod.DELETE, null, String.class);
        log.info("del数据请求:" + response.getBody());

        return result;
    }


}
