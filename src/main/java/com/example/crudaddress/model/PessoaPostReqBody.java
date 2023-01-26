package com.example.crudaddress.model;


import com.example.crudaddress.persistence.Endereco;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PessoaPostReqBody {

    private String nome;
    private LocalDate nascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos;

}
