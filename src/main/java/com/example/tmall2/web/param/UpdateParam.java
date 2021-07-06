package com.example.tmall2.web.param;

import lombok.Data;

@Data
public class UpdateParam {

    private Long userId;

    private String nickName;

    private String passwordMd5;

    private String introduceSign;


}
