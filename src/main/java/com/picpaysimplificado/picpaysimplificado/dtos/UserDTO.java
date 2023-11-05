package com.picpaysimplificado.picpaysimplificado.dtos;

import java.math.BigDecimal;

public record UserDTO(String nome, String sobreNome, String email, String passoword, BigDecimal balance, String document) {
}
