package com.oraclecube.whitecard.model.request;

import com.alibaba.fastjson.JSON;
import com.oraclecube.whitecard.model.User;

/**
 * Created by xiongbanglong on 2017/6/28.
 */
public class CreateUserRequest extends Request{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "CreateUserRequest:" + JSON.toJSONString(this);
    }
}
