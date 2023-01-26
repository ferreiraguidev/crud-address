package com.example.crudaddress.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PessoaPutRequestBody {
    private Long id;
    private String nome;
    private LocalDate nascimento;

}
