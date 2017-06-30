package com.oraclecube.whitecard.service.imp;

import com.oraclecube.whitecard.model.User;
import com.oraclecube.whitecard.repository.UserRepository;
import com.oraclecube.whitecard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiongbanglong on 2017/6/29.
 */
@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isUserRegistered(String username, String password) {
        User user = userRepository.findByNameAndPassword(username,password);
        return user != null;
    }


}
