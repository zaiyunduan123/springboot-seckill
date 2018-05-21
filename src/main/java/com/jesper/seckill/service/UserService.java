package com.jesper.seckill.service;

import com.jesper.seckill.bean.User;
import com.jesper.seckill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangyunxiong on 2018/5/21.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(int id){
        return userMapper.getById(id);
    }

}
