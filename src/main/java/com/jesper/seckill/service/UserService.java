package com.jesper.seckill.service;

import com.jesper.seckill.bean.User;
import com.jesper.seckill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public boolean doubleInsert(){
        User u1 = new User();
        u1.setId(1);
        u1.setName("Jesper");
        userMapper.insert(u1);

        User u2 = new User();
        u1.setId(3);
        u1.setName("Jesp2222er");
        userMapper.insert(u2);

        return true;
    }
}
