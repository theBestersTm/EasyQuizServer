package com.easyquiz.EasyQuizServer.controller;

import com.easyquiz.EasyQuizServer.entity.User;
import com.easyquiz.EasyQuizServer.entity.dto.UserDto;
import com.easyquiz.EasyQuizServer.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sgva1 on 4/5/2020.
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity registerUser(@RequestBody User json) {
        int statusCode = 400;
        if (userService.save(json))
            statusCode = 200;
        return ResponseEntity
                .status(statusCode)
                .body(json);
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody User user) {
        User ownUser = userService.getByUsername(user.getUsername());
        int statusCode = 400;
        if (user.getPassword().equals(ownUser.getPassword())) {
            statusCode = 200;
        }
        return ResponseEntity
                .status(statusCode)
                .body(user);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getIdByUsername(@PathVariable String username) {

        User byUsername = userService.getByUsername(username);

        UserDto map = modelMapper.map(byUsername, UserDto.class);
        map.getQuizes().forEach(quizeDto -> quizeDto.setUser_id(byUsername.getId()));
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);

    }
}
