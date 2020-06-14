package com.netease.house.springcloudopenfeignconsumer.remote;

import org.springframework.stereotype.Component;

@Component
public class DefaultFailback implements TestFeign {

    @Override
    public String get1() {
        return "error:get1";
    }

    @Override
    public String get2(Long id) {
        return "error:get2";
    }

}
