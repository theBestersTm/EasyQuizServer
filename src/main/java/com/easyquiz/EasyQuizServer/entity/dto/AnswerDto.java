package com.easyquiz.EasyQuizServer.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sgva1 on 5/13/2020.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long id;
    private String answer;
    private Integer right_answer;
}
