package com.oraclecube.whitecard.model.request;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
public class QueryUserRequest extends Request {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString(){
        return "QueryUserRequest:" + JSON.toJSONString(this);
    }
}
