package com.easyquiz.EasyQuizServer.service;

import com.easyquiz.EasyQuizServer.entity.Answer;
import com.easyquiz.EasyQuizServer.entity.Quize;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Created by sgva1 on 5/9/2020.
 */

@Service
@AllArgsConstructor
public class QuizAdapter implements JsonSerializer<Quize> {

    private AnswerAdapter answerAdapter;
    private Gson gson;

    @Override
    public JsonElement serialize(Quize quize, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", quize.getId());
        jsonObject.addProperty("question", quize.getQuestion());
        jsonObject.addProperty("user_id", quize.getUsers().getId());
        if (!quize.getAnswers().isEmpty())
            jsonObject.add("answer", gson.toJsonTree(quize.getAnswers(), new TypeToken<Set<Answer>>() {
            }.getType()));
        return jsonObject;
    }

    @PostConstruct
    public void init() {
        gson = new GsonBuilder().registerTypeAdapter(Answer.class, answerAdapter)
                .create();
    }
}
