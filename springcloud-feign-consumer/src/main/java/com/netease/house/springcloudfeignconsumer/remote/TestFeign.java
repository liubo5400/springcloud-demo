package com.netease.house.springcloudfeignconsumer.remote;

import feign.RequestLine;
import lombok.Builder;

public interface TestFeign {

    @RequestLine("GET /api/get1")
    String get1();
}
