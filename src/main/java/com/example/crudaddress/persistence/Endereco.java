package com.example.crudaddress.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;


import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private boolean principal;

    @ManyToOne()
    @JsonIgnore
    private Pessoa pessoa;

}
