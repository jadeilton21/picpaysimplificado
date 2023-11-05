package com.picpaysimplificado.picpaysimplificado.services;


import com.picpaysimplificado.picpaysimplificado.doMain.user.TypeUser;
import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.doMain.user.UserRepository;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserServices {




    @Autowired
    private UserRepository userRepository;



    public void validateTransection(User sender, BigDecimal amout) throws Exception{

        if(sender.getTypeUser() == TypeUser.LOGISTAS){
            throw new Exception("O úsuario do Tipo Lógista não está autorizado a fazer a transação.");
        }

        if(sender.getBalance().compareTo(amout) < 0){
            throw new Exception("O seu saldo é Insuficiente");
        }

    }


    public User findUserById(Long id) throws Exception{

        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usúario não Encontrado."));

    }


    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saverUser(newUser);
        return newUser;

    }


    public void saverUser(User user){
        this.userRepository.save(user);
    }

}
