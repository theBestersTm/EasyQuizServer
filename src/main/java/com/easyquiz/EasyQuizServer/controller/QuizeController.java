package com.easyquiz.EasyQuizServer.controller;

import com.easyquiz.EasyQuizServer.entity.Answer;
import com.easyquiz.EasyQuizServer.entity.Quize;
import com.easyquiz.EasyQuizServer.entity.dto.AnswerDto;
import com.easyquiz.EasyQuizServer.entity.dto.QuizeDto;
import com.easyquiz.EasyQuizServer.service.AnswerService;
import com.easyquiz.EasyQuizServer.service.QuizAdapter;
import com.easyquiz.EasyQuizServer.service.QuizService;
import com.easyquiz.EasyQuizServer.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sgva1 on 5/9/2020.
 */

@RestController
@RequestMapping("/quize")
@AllArgsConstructor
public class QuizeController {

    private QuizService quizService;
    private UserService userService;
    private AnswerService answerService;
    private QuizAdapter quizAdapter;

    @PostMapping
    public ResponseEntity addQuize(@RequestBody QuizeDto json) {

        Quize quize = new Quize();
        quize.setUsers(userService.getById(json.getUser_id()));
        quize.setQuestion(json.getQuestion());
        quize.setAnswers(json.getAnswers().stream().map(answerDto -> new Answer(answerDto.getAnswer(), quize, answerDto.getRight_answer())).collect(Collectors.toSet()));

        quizService.save(quize);
        answerService.saveAll(quize.getAnswers());

        int statusCode = 200;
        return ResponseEntity
                .status(statusCode)
                .body(json);
    }

    @PatchMapping
    public ResponseEntity editeQuize(@RequestBody Quize json) {
        int statusCode = 400;
        if (Optional.of(quizService.edit(json)).isPresent()) {
            statusCode = 200;
        }
        return ResponseEntity
                .status(statusCode)
                .body(json);
    }

    @GetMapping
    public ResponseEntity getAllQuize() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Quize.class, quizAdapter)
                .create();
        return ResponseEntity
                .status(200)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(
                        quizService.getAll()
                        .stream()
                        .map(quize -> new QuizeDto(quize.getQuestion(), quize.getUsers().getId(),
                        quize.getAnswers()
                                .stream()
                                .map(answer -> new AnswerDto(answer.getId(), answer.getAnswer(), null))
                                .collect(Collectors.toSet()))
                        )
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity
                .status(200)
                .body(quizService.getById(id));
    }
}
