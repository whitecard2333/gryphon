package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;
import com.oraclecube.whitecard.model.User;

/**
 * Created by xiongbanglong on 2017/5/10.
 */
public class CreateUserResponse extends Response {
    private Integer id;
    private Boolean success;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CreateUserResponse" + JSON.toJSONString(this);
    }
}
