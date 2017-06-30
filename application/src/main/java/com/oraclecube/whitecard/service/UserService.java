package com.oraclecube.whitecard.service;

import com.oraclecube.whitecard.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by xiongbanglong on 2017/6/29.
 */

public interface UserService {
    User saveUser(User user);
    Boolean isUserRegistered(String username,String password);
}