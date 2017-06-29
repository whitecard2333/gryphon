package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;
import com.oraclecube.whitecard.model.User;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class CreateUserResponse extends Response {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CreateUserResponse:" + JSON.toJSONString(this);
    }
}
