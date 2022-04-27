package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.Answer;
import com.easyquiz.EasyQuizServer.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sgva1 on 5/9/2020.
 */

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Override
    public boolean save(Answer answer) {
        return Optional.of(answerRepository.save(answer)).isPresent();
    }

    @Override
    public Answer getById(Long id) {
        return null;
    }

    @Override
    public Collection<Answer> getAll() {
        return null;
    }

    @Override
    public Answer edit(Answer answer) {
        return null;
    }

    @Override
    public void delete(Answer answer) {

    }

    @Override
    public void saveAll(Collection<Answer> answers) {
        answerRepository.saveAll(answers);
    }
}
