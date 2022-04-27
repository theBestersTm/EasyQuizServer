package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.Answer;
import com.easyquiz.EasyQuizServer.entity.Quize;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * Created by sgva1 on 5/9/2020.
 */

@Service
public class AnswerAdapter implements JsonSerializer<Answer> {
    @Override
    public JsonElement serialize(Answer answer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", answer.getId());
        jsonObject.addProperty("answer", answer.getAnswer());
        jsonObject.addProperty("right_answer", answer.getRight_answer());
        jsonObject.addProperty("quiz_id", answer.getQuize().getId());
        return jsonObject;
    }
}
