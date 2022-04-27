package com.easyquiz.EasyQuizServer.repository;

import com.easyquiz.EasyQuizServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sgva1 on 4/5/2020.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailOrUsername(String email, String username);

    User getByUsername(String username);
}
