package com.picpaysimplificado.picpaysimplificado.doMain.user;


import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import javax.swing.text.Document;
import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;

    @Column(unique = true)
    private String document;
    @Email
    @Column(unique=true)
    private String email;


    private String passoword;
    private BigDecimal Balance;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    private boolean ativo;


    public User(UserDTO data) {
        this.nome = data.nome();
        this.sobreNome = data.sobreNome();
        this.document = data.document();
        this.email = data.email();
        this.passoword = data.passoword();
        this.Balance = data.balance();
        this.typeUser = data.typeUser();
    }

    public void excluir() {
        this.ativo = false;
    }
}
