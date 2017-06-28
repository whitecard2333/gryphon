package com.oraclecube.whitecard.controller;

import com.oraclecube.whitecard.model.request.CreateUserRequest;
import com.oraclecube.whitecard.model.response.CreateUserResponse;
import com.oraclecube.whitecard.model.response.JsonResponse;
import com.oraclecube.whitecard.repository.UserRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiongbanglong on 2017/6/28.
 */

@RestController
@RequestMapping(value = "/commonapi/user", consumes = {"application/json"}, produces = {"application/json"})
@Api(produces = "application/json", consumes = "application/json", protocols = "https")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET, consumes = {"*/*"})
    @ResponseBody
    @ApiOperation(value = "", notes = "test status", tags = {"Common API"})
    @ApiImplicitParams({})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = JsonResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",response = JsonResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized",response = JsonResponse.class),
            @ApiResponse(code = 403, message = "Forbidden",response = JsonResponse.class),
            @ApiResponse(code = 404, message = "Not Found",response = JsonResponse.class),
            @ApiResponse(code = 500, message = "Internal Error",response = JsonResponse.class)})
    public CreateUserResponse sayHello(@RequestBody CreateUserRequest request){
        return null;
    }
}
