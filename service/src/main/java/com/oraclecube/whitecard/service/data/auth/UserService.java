package com.oraclecube.whitecard.service.data.auth;

import com.oraclecube.whitecard.core.data.entity.auth.User;
import com.oraclecube.whitecard.core.data.repository.auth.UserRepository;
import com.oraclecube.whitecard.service.data.BaseDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * Created by zhouhu on 25/4/2017.
 */
@ConditionalOnProperty(prefix = "gryphon.config.enableJpa.map", name = {"default"}, havingValue = "true")
@Service
public class UserService extends BaseDataService<UserRepository, User, String> {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

}
