package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.User;
import com.easyquiz.EasyQuizServer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by sgva1 on 4/5/2020.
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public boolean save(User user) {
        if (userRepository.findAllByEmailOrUsername(user.getEmail(), user.getUsername()).isEmpty()) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User edit(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
