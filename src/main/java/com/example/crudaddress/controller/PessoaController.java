package com.example.crudaddress.controller;


import com.example.crudaddress.model.PessoaPostReqBody;
import com.example.crudaddress.model.PessoaPutRequestBody;
import com.example.crudaddress.persistence.Pessoa;
import com.example.crudaddress.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    @PostMapping
    public Pessoa save(@RequestBody PessoaPostReqBody pessoaPostReqBody) {
        return pessoaService.salvar(pessoaPostReqBody);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody PessoaPutRequestBody pessoaPutRequestBody) {
        pessoaPutRequestBody.setId(id);
        return pessoaService.editar(pessoaPutRequestBody);
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.listaTodasPessoas();
    }
}
