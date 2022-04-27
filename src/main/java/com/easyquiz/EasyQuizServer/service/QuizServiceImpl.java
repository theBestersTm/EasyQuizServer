package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.Quize;
import com.easyquiz.EasyQuizServer.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sgva1 on 5/8/2020.
 */

@Controller
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    @Override
    public boolean save(Quize quize) {
        return Optional.of(quizRepository.save(quize)).isPresent();
    }

    @Override
    public Quize getById(Long id) {
        return quizRepository.getOne(id);
    }

    @Override
    public Collection<Quize> getAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quize edit(Quize quize) {
        return quizRepository.saveAndFlush(quize);
    }

    @Override
    public void delete(Quize quize) {
        quizRepository.delete(quize);
    }
}
