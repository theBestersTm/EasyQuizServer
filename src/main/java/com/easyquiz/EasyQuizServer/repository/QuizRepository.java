package com.easyquiz.EasyQuizServer.repository;

import com.easyquiz.EasyQuizServer.entity.Quize;
import com.easyquiz.EasyQuizServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sgva1 on 5/8/2020.
 */
public interface QuizRepository extends JpaRepository<Quize, Long> {
    List<Quize> getAllByUsersAndId(User user, Long id);
    List<Quize> getAllByUsers(User user);
}
