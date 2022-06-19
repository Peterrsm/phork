package com.pedro.fork.controller;

import com.pedro.fork.model.Pessoa;
import com.pedro.fork.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PessoaControllerTest {
    PessoaService service = new PessoaService();
    List<Pessoa> listaPessoas = new ArrayList<>();

    @BeforeEach
    private void iniciaListaPessoas(){
        listaPessoas.add(new Pessoa("Ana", Arrays.asList("Vinicius", "Maria", "Carlos", "Joao")));
        listaPessoas.add(new Pessoa("Maria", Arrays.asList("Ana", "Vinicius")));
        listaPessoas.add(new Pessoa("Vinicius", Arrays.asList("Ana", "Maria")));
        listaPessoas.add(new Pessoa("Carlos", Arrays.asList("Ana")));
        listaPessoas.add(new Pessoa("Joao", Arrays.asList("Ana", "Luiza")));
        listaPessoas.add(new Pessoa("Luiza", Arrays.asList("Joao")));
    }

    @Test
    public void getPessoasTest(){
        assert(!service.getPerson(listaPessoas).isEmpty());
    }

    @Test
    public void cadastraPessoaTest(){
        Pessoa pedro = new Pessoa("Pedro", Arrays.asList("Ana"));
        listaPessoas.add(pedro);
        assert(listaPessoas.contains(pedro));
    }

    @Test
    public void getPessoa() {
        int id = 1;
        assert(listaPessoas.get(id) != null);
    }

    @Test
    public void getConhecidosDeAlguemTest(){
        String nome = "Ana";
        assert(!service.getSomeoneFriends(nome, listaPessoas).isEmpty());
    }

    @Test
    public void getPessoasRelacionadasTest() {
        String nome = "Ana";
        assert(!service.getRelatedPerson(nome, listaPessoas).isEmpty());
    }
}