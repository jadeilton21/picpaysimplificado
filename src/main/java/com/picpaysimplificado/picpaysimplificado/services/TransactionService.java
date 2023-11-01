package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.doMain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.doMain.transaction.TransactionRepository;
import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;


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


        boolean isAuthorized = this.authorizedTrasaction(sender,transaction.value());
            if(!isAuthorized){
                throw new Exception("Transação não Autorizada.");

        }


        Transaction newtransaction = new Transaction();
            newtransaction.setAmount(transaction.value());
            newtransaction.setSender(sender);
            newtransaction.setReceiver(receiver);
            newtransaction.setLocalDateTime(LocalDateTime.now());


            sender.setBalance(sender.getBalance().subtract(transaction.value()));
            receiver.setBalance(receiver.getBalance().add(transaction.value()));

            this.repository.save(newtransaction);
            this.userServices.saverUser(sender);
            this.userServices.saverUser(receiver);
    }

    public boolean authorizedTrasaction(User sender, BigDecimal value){

        ResponseEntity<Map>  authorizeResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);


        if(authorizeResponse.getStatusCode() == HttpStatus.OK){
            String message = (String) authorizeResponse.getBody().get("message");

            return "Autorizado".equalsIgnoreCase(message);

        }else return false;
    }
}
