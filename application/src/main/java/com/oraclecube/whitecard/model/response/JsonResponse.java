package com.oraclecube.whitecard.model.response;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 * Gryphon REST API JSON response
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse implements Serializable {
    private static final long serialVersionUID = 8407357554057531490L;
    private int code;
    private String requestId;
    private String status;
    private String action;
    private String path;
    private Object data;
    private String callbackPath;
    private String error;
    private String exception;
    private long timestatmp;
    private long duration;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCallbackPath() {
        return callbackPath;
    }

    public void setCallbackPath(String callbackPath) {
        this.callbackPath = callbackPath;
    }

    public long getTimestatmp() {
        return timestatmp;
    }

    public void setTimestatmp(long timestatmp) {
        this.timestatmp = timestatmp;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "JsonResponse:" + JSON.toJSONString(this);
    }
}
