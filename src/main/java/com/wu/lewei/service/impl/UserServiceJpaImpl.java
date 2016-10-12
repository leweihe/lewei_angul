package com.wu.lewei.service.impl;

import com.wu.lewei.dto.UserDTO;
import com.wu.lewei.repo.UserRepository;
import com.wu.lewei.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by cn40580 on 2016-10-10.
 */
@Component("userService")
public class UserServiceJpaImpl implements UserService {

    private static final Log LOG = LogFactory.getLog(UserServiceJpaImpl.class);

    @Inject
    private UserRepository userRepository;

    public UserDTO findUserByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll();
    }

}
