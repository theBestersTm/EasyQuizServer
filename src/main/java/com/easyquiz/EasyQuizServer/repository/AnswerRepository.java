package com.easyquiz.EasyQuizServer.repository;

import com.easyquiz.EasyQuizServer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sgva1 on 5/9/2020.
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
