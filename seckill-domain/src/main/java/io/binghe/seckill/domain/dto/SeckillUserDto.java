package io.binghe.seckill.domain.dto;

import java.io.Serializable;

/**
 * @author YouChuande
 */
public class SeckillUserDto implements Serializable {
    private static final long serialVersionUID= 1L;

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public SeckillUserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SeckillUserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
