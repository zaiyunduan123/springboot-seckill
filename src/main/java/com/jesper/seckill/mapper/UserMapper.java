package com.jesper.seckill.mapper;

import com.jesper.seckill.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by jiangyunxiong on 2018/5/21.
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from sk_user where id = #{id}")
    public User getById(@Param("id")long id);

    @Select("select * from sk_user where nickname = #{nickname}")
    public User getByNickname(@Param("nickname")String nickname);

    @Update("update sk_user set password = #{password} where id = #{id}")
    public void update(User toBeUpdate);
}
