package com.oraclecube.whitecard.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiongbanglong on 2017/6/27.
 */
@RestController
@RequestMapping(value = "/commonapi", consumes = {"application/json"}, produces = {"application/json"})
@Api(produces = "application/json", consumes = "application/json", protocols = "https")
public class UserController extends CommonController {

}
