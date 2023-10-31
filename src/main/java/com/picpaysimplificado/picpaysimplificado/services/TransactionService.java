package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.doMain.transaction.TransactionRepository;
import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class TransactionService {



    @Autowired
    private TransactionRepository repository;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServices userServices;



    public void createTransaction(TransactionDTO transaction) throws Exception{

        User sender = this.userServices.findUserById(transaction.senderId());
        User receiver = this.userServices.findUserById(transaction.receiverId());

        userServices.validateTransection(sender,transaction.value());


    }
}
