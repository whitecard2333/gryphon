package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;
import com.oraclecube.whitecard.model.User;

import java.net.UnknownServiceException;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
public class QueryUserResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "QueryUserResponse:" + JSON.toJSONString(this);
    }
}
