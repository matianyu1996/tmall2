package com.example.tmall2.service.impl;

import com.example.tmall2.common.Constants;
import com.example.tmall2.model.UserDO;
import com.example.tmall2.repository.UserRepository;
import com.example.tmall2.service.UserService;
import com.example.tmall2.util.Md5Util;
import com.example.tmall2.web.param.UpdateParam;
import com.example.tmall2.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

@Service
public class UserServiceImpl implements UserService {

    private static final String UTF8_CHARSET ="UTF-8";
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserVO register(String loginName, String password) {

        UserDO registerUser = new UserDO();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);

        registerUser.setIntroduceSign(Constants.USER_INTRO);

        registerUser.setPasswordMd5(Md5Util.Md5Encode(password, UTF8_CHARSET));

        UserDO savedUser = userRepository.save(registerUser);

        //TODO
        UserVO userVO = new UserVO();
        userVO.setLoginName(registerUser.getLoginName());
        userVO.setNickName(registerUser.getNickName());
        userVO.setIntroduceSign(registerUser.getIntroduceSign());
        return userVO;
    }

    @Override
    public UserVO login(String loginName, String passwordMd5) {

        UserDO foundUser = userRepository.findUserDOByLoginName(loginName);

        UserVO userVO = new UserVO();
        userVO.setLoginName(foundUser.getLoginName());
        userVO.setNickName(foundUser.getNickName());
        userVO.setIntroduceSign(foundUser.getIntroduceSign());
        return userVO;
    }

    @Override
    public UserVO updateUserInfo(UpdateParam user, Long userId) {
        UserDO foundUser = userRepository.findUserDOByUserId(userId);

        if(user.getNickName()!=null){
            foundUser.setNickName(user.getNickName());
        }

        if(user.getIntroduceSign()!=null){
            foundUser.setIntroduceSign(user.getIntroduceSign());
        }

        UserDO savedUser = userRepository.save(foundUser);

        UserVO userVO = new UserVO();
        userVO.setLoginName(savedUser.getLoginName());
        userVO.setNickName(savedUser.getNickName());
        userVO.setIntroduceSign(savedUser.getIntroduceSign());
        return userVO;
    }


}
