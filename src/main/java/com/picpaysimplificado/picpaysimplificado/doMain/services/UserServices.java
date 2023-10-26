package com.picpaysimplificado.picpaysimplificado.doMain.services;


import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.doMain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServices {




    @Autowired
    private UserRepository userRepository;



    public void validateTransection(User sender, BigDecimal amout) throws Exception{

    }


}
