package com.example.crudaddress.controller;


import com.example.crudaddress.model.EnderecoPostReqBody;
import com.example.crudaddress.persistence.Endereco;
import com.example.crudaddress.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public Endereco salvar(@RequestBody EnderecoPostReqBody enderecoPostReqBody) throws Exception {
       return enderecoService.salvar(enderecoPostReqBody);

    }

    @GetMapping
    public List<Endereco> listaTodosEnderecos() {
        return enderecoService.listaTodosEnderecos();
    }

    @PatchMapping("/{id}/principal")
    public void enderecoPrincipal(@PathVariable Long id) {
        enderecoService.enderecoPrincipal(id);
    }
}

