package com.easyquiz.EasyQuizServer.controller;

import com.easyquiz.EasyQuizServer.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sgva1 on 5/13/2020.
 */

@RestController
@AllArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService answerService;

    @GetMapping("/{id}")
    public ResponseEntity getAnswerById(@PathVariable Long id) {
        return ResponseEntity
                .status(200)
                .body(answerService.getById(id));
    }
}
