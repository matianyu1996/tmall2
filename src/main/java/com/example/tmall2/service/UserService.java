package com.example.tmall2.service;

import com.example.tmall2.web.param.UpdateParam;
import com.example.tmall2.web.vo.UserVO;

public interface UserService {
    /**
     *
     * @param loginName
     * @param password
     * @return
     */
    UserVO register(String loginName, String password);

    /**
     *
     * @param loginName
     * @param passwordMd5
     * @return
     */
    UserVO login(String loginName, String passwordMd5);

    UserVO updateUserInfo(UpdateParam user, Long userId);
}


