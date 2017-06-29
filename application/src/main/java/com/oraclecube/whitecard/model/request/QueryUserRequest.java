package com.oraclecube.whitecard.model.request;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
public class QueryUserRequest {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "QueryUserRequest:" + JSON.toJSONString(this);
    }
}
