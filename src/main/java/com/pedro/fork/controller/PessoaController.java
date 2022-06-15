package com.pedro.fork.controller;

import com.pedro.fork.enums.PessoaEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fork")
public class PessoaController {
    @GetMapping("/")
    public String informaFuncionando(){
        return "Deu certo";
    }

    @GetMapping("/pessoas")
    public List getPessoa(){
        List<PessoaEnum> listaPessoas = Arrays.asList(PessoaEnum.values());

        return listaPessoas;
    }

    @GetMapping("/pessoas/conhecidas/ana")
    public List<PessoaEnum> getConhecidos(){
        List<PessoaEnum> listaPessoas = PessoaEnum.ANA.knows();

        return listaPessoas;
    }
}
