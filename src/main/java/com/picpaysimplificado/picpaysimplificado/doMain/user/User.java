package com.picpaysimplificado.picpaysimplificado.doMain.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;
    @Column(insertable = true)
    private String document;
    @Email
    @Column(insertable = true)
    private String email;

    private String passoword;
    private BigDecimal bigDecimal;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;







}
