package com.example.tmall2.web.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginParam {

    @NotEmpty(message = "cannot empty")
    private String loginName;

    @NotEmpty(message = "not empty")
    private String passwordMd5;
}
