package com.jesper.seckill.vo;

import com.jesper.seckill.validator.IsMobile;

import javax.validation.constraints.NotNull;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
public class LoginVo {

    @NotNull
    @IsMobile  //因为框架没有校验手机格式注解，所以自己定义
    private String mobile;

    @NotNull
    private String password;

    private String nickname;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
