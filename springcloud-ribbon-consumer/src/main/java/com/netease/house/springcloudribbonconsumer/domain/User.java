package com.netease.house.springcloudribbonconsumer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;

    private String mobile;
}
