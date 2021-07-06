package com.example.tmall2.repository;

import com.example.tmall2.model.UserDO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserDO,Long>{

    UserDO save(UserDO userDO);

    UserDO findUserDOByLoginName(String loginName);

    UserDO findUserDOByUserId(Long userId);
}
