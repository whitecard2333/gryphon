package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class CreateUserResponse extends Response {
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "CreateUserResponse:" + JSON.toJSONString(this);
    }
}
