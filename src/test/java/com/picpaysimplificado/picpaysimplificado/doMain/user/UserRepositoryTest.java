package com.picpaysimplificado.picpaysimplificado.doMain.user;

import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.EntityManager;
import org.apache.catalina.UserDatabase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserRepositoryTest {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should get User successFully from DB")
    void findUserByDocument_Caso1(){

        String document = "999999999901";
        UserDTO data = new UserDTO("Jadeilindo","Felix","jaderasta@gmail.com","4444", new BigDecimal(10),document,TypeUser.USUARIOSLOCAIS);
        this.createUser(data);

        Optional<User> result = this.userRepository.findUserByDocument(document);
        assertThat(result.isPresent()).isTrue();
    }

    private User createUser(UserDTO data){
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return newUser;
    }
}