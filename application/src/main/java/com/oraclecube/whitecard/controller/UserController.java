package com.oraclecube.whitecard.controller;

import com.oraclecube.whitecard.annotation.DefaultApiResponse;
import com.oraclecube.whitecard.model.User;
import com.oraclecube.whitecard.model.request.CreateUserRequest;
import com.oraclecube.whitecard.model.request.QueryUserRequest;
import com.oraclecube.whitecard.model.request.ValidateUserRequest;
import com.oraclecube.whitecard.model.response.CreateUserResponse;
import com.oraclecube.whitecard.model.response.JsonResponse;
import com.oraclecube.whitecard.model.response.ValidateUserResponse;
import com.oraclecube.whitecard.repository.UserRepository;
import com.oraclecube.whitecard.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Created by xiongbanglong on 2017/6/28.
 */

@RestController
@RequestMapping(value = "/commonapi/users", consumes = {"application/json"}, produces = {"application/json"})
@Api(produces = "application/json", consumes = "application/json", protocols = "https")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*
    注册一个新用户
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = {"*/*"})
    @ResponseBody
    @ApiOperation(value = "", notes = "create one new user", tags = {"Common API"})
    @ApiImplicitParams({})
    public CreateUserResponse addUser(@RequestBody CreateUserRequest request){
        CreateUserResponse response = new CreateUserResponse();
        response.setRequestId(UUID.randomUUID().toString());
        if(request != null){
            logger.info(request.toString());
            User user = userService.saveUser(request.getUser());
            if(user != null){
                response.setId(user.getId());
                response.setSuccess(true);
            }else {
                response.setSuccess(false);
            }
        }

        if(response != null){
            logger.info(response.toString());
        }
        return response;
    }

    /*
    验证是否为注册用户
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST, consumes = {"*/*"})
    @ResponseBody
    @ApiOperation(value = "", notes = "verify if user is registered?", tags = {"Common API"})
    @ApiImplicitParams({})
    public ValidateUserResponse checkUser(@RequestBody ValidateUserRequest request){
        ValidateUserResponse response = new ValidateUserResponse();
        response.setRequestId(UUID.randomUUID().toString());
        if(request != null){
            Boolean status = userService.isUserRegistered(request.getUsername(),request.getPassword());
            response.setIsRegistered(status);
        }

        if(response != null){
            logger.info(response.toString());
        }
        return response;
    }

}
