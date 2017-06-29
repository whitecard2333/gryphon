package com.oraclecube.whitecard.service.imp;

import com.oraclecube.whitecard.model.User;
import com.oraclecube.whitecard.repository.UserRepository;
import com.oraclecube.whitecard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
