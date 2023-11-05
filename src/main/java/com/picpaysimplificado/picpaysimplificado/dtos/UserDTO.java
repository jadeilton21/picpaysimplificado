package com.picpaysimplificado.picpaysimplificado.dtos;

import com.picpaysimplificado.picpaysimplificado.doMain.user.TypeUser;

import java.math.BigDecimal;

public record UserDTO(String nome, String sobreNome, String email, String passoword, BigDecimal balance, String document,
                      TypeUser typeUser) {
}
