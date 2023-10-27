package com.picpaysimplificado.picpaysimplificado.doMain.user;


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







}
