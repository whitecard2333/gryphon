package com.oraclecube.whitecard.service;

import com.oraclecube.whitecard.model.User;

import java.util.List;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
public interface UserService {
    User saveUser(User user);
    List<User> findAll();
}
