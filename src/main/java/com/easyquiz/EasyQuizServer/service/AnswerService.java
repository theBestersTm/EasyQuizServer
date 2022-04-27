package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.Answer;

import java.util.Collection;

/**
 * Created by sgva1 on 5/9/2020.
 */
public interface AnswerService extends BaseMethods<Answer> {
    void saveAll(Collection<Answer> answers);
}
