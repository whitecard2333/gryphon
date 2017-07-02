package com.oraclecube.whitecard.application.helper;

import com.oraclecube.whitecard.application.model.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * Created by zhouhu on 22/4/2017.
 */
@Component
public class ControllerHelper {
    private static final Logger logger = LoggerFactory.getLogger(ControllerHelper.class);

    public JsonResponse
    getSuccessResponse(String action, Object... datas) {
        JsonResponse response = new JsonResponse();
        response.setAction(action);
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        if (datas.length == 1 && (datas[0] instanceof Collection)) {
            response.setData(datas[0]);
        } else {
            response.setData(Arrays.asList(datas));
        }
        return response;
    }
}
