package com.oraclecube.whitecard.model.response;

import java.io.Serializable;

/**
 * Created by xiongbanglong on 2017/4/28.
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 8447357854023531470L;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
