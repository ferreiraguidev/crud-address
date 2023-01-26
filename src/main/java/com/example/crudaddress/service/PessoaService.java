package com.example.crudaddress.service;


import com.example.crudaddress.model.PessoaPostReqBody;
import com.example.crudaddress.model.PessoaPutRequestBody;
import com.example.crudaddress.persistence.Pessoa;
import com.example.crudaddress.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvar(PessoaPostReqBody pessoaPostReqBody) {
         var pessoa = Pessoa.builder()
                .nome(pessoaPostReqBody.getNome())
                .nascimento(pessoaPostReqBody.getNascimento())
                .build();

      return pessoaRepository.save(pessoa);

    }

    public List<Pessoa> listaTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Pessoa Não encontrada"));
    }

    public Pessoa editar(PessoaPutRequestBody pessoaPutRequestBody) {
        var porId = findById(pessoaPutRequestBody.getId());

        if (porId == null) {
            throw new NoSuchElementException("Não foi possível encontrar o ID");
        }

        porId.setId(pessoaPutRequestBody.getId());
        porId.setNome(pessoaPutRequestBody.getNome());
        porId.setNascimento(pessoaPutRequestBody.getNascimento());
        return porId;

    }
}
