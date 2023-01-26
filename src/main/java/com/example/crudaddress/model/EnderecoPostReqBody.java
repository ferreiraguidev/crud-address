package com.example.crudaddress.model;


import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class EnderecoPostReqBody {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @NotNull
    private Long pessoaId;

}
