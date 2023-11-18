package com.picpaysimplificado.picpaysimplificado.controller;

import com.picpaysimplificado.picpaysimplificado.doMain.user.DadosDetalhamentoUsers;
import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.doMain.user.UserRepository;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.picpaysimplificado.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {



    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO userDTO){
        User newUser = userServices.createUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<User>> listUser(){

        List<User> users = this.userServices.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluirUser(@PathVariable Long id){
        var user = repository.getReferenceById(id);

        user.excluir();

        return ResponseEntity.noContent().build();

    }

    public ResponseEntity detalharUser (@PathVariable Long id){
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUsers(user));
    }




}
