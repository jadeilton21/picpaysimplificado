package com.picpaysimplificado.picpaysimplificado.doMain.user;

import java.math.BigDecimal;

public record DadosDetalhamentoUsers(Long id, String nome, String sobreNome, String document, String email, String passoword, BigDecimal balance, TypeUser typeUser) {


    public DadosDetalhamentoUsers (User user){
        this(user.getId(),user.getNome(),user.getSobreNome(),user.getDocument(),user.getEmail(),user.getPassoword(),user.getBalance(),user.getTypeUser());
    }

    public DadosDetalhamentoUsers(Long id, String nome, String sobreNome, String document, String email, String passoword, BigDecimal balance, TypeUser typeUser) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.document = document;
        this.email = email;
        this.passoword = passoword;
        this.balance = balance;
        this.typeUser = typeUser;
    }
}
