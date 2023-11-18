package com.picpaysimplificado.picpaysimplificado.doMain.user;

import java.math.BigDecimal;

public record DadosDetalhamentoUsers(Long id, String nome, String sobreNome, String document, String email, String passoword, BigDecimal balance, TypeUser typeUser) {


    public DadosDetalhamentoUsers (User user){
        this(user.getId(),user.getNome(),user.getSobreNome(),user.getDocument(),user.getEmail(),user.getPassoword(),user.getBalance(),user.getTypeUser());
    }

}
