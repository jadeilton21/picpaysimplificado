package com.picpaysimplificado.picpaysimplificado.doMain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DadosDetalhamentoUsersTest {


    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Deve devolver Código http 400 quando informações estiverem invalidas")
    @WithMockUser
    void dadosDetalhamentoUsersTest_cenario1() throws Exception{


       var response = mockMvc
                .perform(post("/users"))
               .andReturn().getResponse();

       assertThat(response.getStatus())
               .isEqualTo(HttpStatus.FORBIDDEN.value());


    }


}