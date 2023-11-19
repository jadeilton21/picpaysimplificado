package com.picpaysimplificado.picpaysimplificado.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Deve Devolver Código Http 403 quando informações estiverem invalidas..")
    void createUser_cenario1() throws Exception {

        var response = mockMvc
                .perform(post("/users"))
                .andReturn().getResponse();


        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.FORBIDDEN.value());


    }


    @Test
    @DisplayName("DEve devolver Código Http 403 quando informações estiverem invalidas,..")
    void listUser() throws Exception{

        var response = mockMvc
                .perform(post("/users"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.FORBIDDEN.value());




    }
}