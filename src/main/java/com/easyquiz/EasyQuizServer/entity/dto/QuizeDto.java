package com.easyquiz.EasyQuizServer.entity.dto;

import com.easyquiz.EasyQuizServer.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by sgva1 on 5/13/2020.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizeDto {
    private String question;
    private Long user_id;
    private Set<AnswerDto> answers;

}
