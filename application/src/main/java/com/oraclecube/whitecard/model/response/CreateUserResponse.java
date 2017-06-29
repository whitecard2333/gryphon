package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;
import com.oraclecube.whitecard.model.User;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class CreateUserResponse extends Response {
    private Integer id;
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
