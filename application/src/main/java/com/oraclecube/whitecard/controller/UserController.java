package com.oraclecube.whitecard.controller;

import com.oraclecube.whitecard.annotation.DefaultApiResponse;
import com.oraclecube.whitecard.model.User;
import com.oraclecube.whitecard.model.request.CreateUserRequest;
import com.oraclecube.whitecard.model.response.CreateUserResponse;
import com.oraclecube.whitecard.model.response.JsonResponse;
import com.oraclecube.whitecard.repository.UserRepository;
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
@RequestMapping(value = "/commonapi/user", consumes = {"application/json"}, produces = {"application/json"})
@Api(produces = "application/json", consumes = "application/json", protocols = "https")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"*/*"})
    @ResponseBody
    @ApiOperation(value = "", notes = "create one new user", tags = {"Common API"})
    @ApiImplicitParams({})
    public CreateUserResponse addUser(@RequestBody CreateUserRequest request){
        CreateUserResponse response = new CreateUserResponse();
        response.setRequestId(UUID.randomUUID().toString());
        if(request != null){
            logger.info(request.toString());
            User user = userRepository.save(request.getUser());
            if(user != null){
                response.setId(user.getId());
                response.setStatus(true);
            }else {
                response.setStatus(false);
            }
        }

        if(response != null){
            logger.info(response.toString());
        }
        return response;
    }
}
