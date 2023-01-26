package com.example.crudaddress.service;


import com.example.crudaddress.model.EnderecoPostReqBody;
import com.example.crudaddress.persistence.Endereco;
import com.example.crudaddress.repository.EnderecoRepository;
import com.example.crudaddress.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;


    public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }


    public Endereco salvar(EnderecoPostReqBody enderecoPostReqBody) throws Exception {

        var endereco =  Endereco.builder()
                .logradouro(enderecoPostReqBody.getLogradouro())
                .cep(enderecoPostReqBody.getCep())
                .numero(enderecoPostReqBody.getNumero())
                .cidade(enderecoPostReqBody.getCidade())
                .pessoa(pessoaRepository.findById(enderecoPostReqBody.getPessoaId())
                        .orElseThrow(() -> new NoSuchElementException("Pessoa não existente")))
                .build();

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listaTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    public void enderecoPrincipal(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new NoSuchElementException("Endereço não encontrado");
        }
        var endereco = enderecoRepository.findById(id).get();
        if (endereco.isPrincipal()) {
            return;
        }
        var enderecosDaPessoa = enderecoRepository.findByPessoa_Id(endereco.getPessoa().getId());
        enderecosDaPessoa.stream()
                .filter(Endereco::isPrincipal)
                .findFirst()
                .ifPresent(enderecoAtual -> {
                    enderecoAtual.setPrincipal(false);
                    enderecoRepository.save(enderecoAtual);
                });
        endereco.setPrincipal(true);
        enderecoRepository.save(endereco);
    }
}
