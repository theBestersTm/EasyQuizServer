package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.User;

/**
 * Created by sgva1 on 4/5/2020.
 */
public interface UserService extends BaseMethods<User> {
    User getByUsername(String username);
}
