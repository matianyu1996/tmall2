package com.example.tmall2.web;

import com.example.tmall2.common.Constants;
import com.example.tmall2.service.UserService;
import com.example.tmall2.web.param.LoginParam;
import com.example.tmall2.web.param.UpdateParam;
import com.example.tmall2.web.param.UserRegisterParam;
import com.example.tmall2.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.WEB_PATH_API_VERSION)
public class UserWeb {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public UserVO register(@RequestBody @Valid UserRegisterParam userRegisterParam){
        UserVO userVO = new UserVO();
        userVO.setLoginName(userRegisterParam.getLoginName());
        userVO.setNickName(userRegisterParam.getLoginName());
        userVO.setIntroduceSign(userRegisterParam.getLoginName());

        return userService.register(userRegisterParam.getLoginName(),userRegisterParam.getPassword());

    }

    @PostMapping("/user/login")
    public UserVO login(@RequestBody @Valid LoginParam loginParam){

        return userService.login(loginParam.getLoginName(), loginParam.getPasswordMd5());
    }

    @PostMapping("/user/info")
    public UserVO updateInfo(@RequestBody UpdateParam updateParam){
        UserVO userVO = userService.updateUserInfo(updateParam, updateParam.getUserId());

        return userVO;
    }
}
