package com.picpaysimplificado.picpaysimplificado.controller;

import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.picpaysimplificado.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
public class UserController {



    @Autowired
    private UserServices userServices;


    @PostMapping
    public ResponseEntity<User> createUser(UserDTO userDTO){
        User newUser = userServices.createUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<User>> listUser(){


    }


}
