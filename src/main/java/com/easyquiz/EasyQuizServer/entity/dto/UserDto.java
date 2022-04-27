package com.easyquiz.EasyQuizServer.entity.dto;

import com.easyquiz.EasyQuizServer.entity.Quize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by sgva1 on 5/30/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Set<QuizeDto> quizes;
}
