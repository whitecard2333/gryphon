package com.oraclecube.whitecard.controller;

import com.oraclecube.whitecard.helper.ControllerHelper;
import com.oraclecube.whitecard.model.response.JsonResponse;
import io.swagger.annotations.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Gryphon common API
 */
@RestController
@RequestMapping(value = "/commonapi", consumes = {"application/json"}, produces = {"application/json"})
@Api(produces = "application/json", consumes = "application/json", protocols = "https")
public class CommonController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ControllerHelper controllerHelper;

    @RequestMapping(value = "/status", method = RequestMethod.GET, consumes = {"*/*"})
    @ResponseBody
    @ApiOperation(value = "test status api", notes = "test status", tags = {"Common API"})
    @ApiImplicitParams({})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = JsonResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",response = JsonResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized",response = JsonResponse.class),
            @ApiResponse(code = 403, message = "Forbidden",response = JsonResponse.class),
            @ApiResponse(code = 404, message = "Not Found",response = JsonResponse.class),
            @ApiResponse(code = 500, message = "Internal Error",response = JsonResponse.class)})
    public JsonResponse testToken(HttpServletRequest request) {
        String action = "test status";
        return controllerHelper.getSuccessResponse(action, "Gryphon status success");
    }
}
