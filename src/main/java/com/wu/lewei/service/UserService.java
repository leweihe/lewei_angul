package com.wu.lewei.service;

import com.wu.lewei.dao.UserDTO;

/**
 * Created by cn40580 on 2016-10-10.
 */
public interface UserService {

    public UserDTO findUserByUserName(String name);
}
