package com.pedro.fork.controller;

import com.pedro.fork.model.Pessoa;
import com.pedro.fork.service.PessoaService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fork")
public class PessoaController {
    PessoaService service = new PessoaService();
    List<Pessoa> listaPessoas = new ArrayList<>();

    @EventListener(ContextRefreshedEvent.class)
    private void iniciaListaPessoas(){
        listaPessoas.add(new Pessoa("Ana", Arrays.asList("Vinicius", "Maria", "Carlos", "Joao")));
        listaPessoas.add(new Pessoa("Maria", Arrays.asList("Ana", "Vinicius")));
        listaPessoas.add(new Pessoa("Vinicius", Arrays.asList("Ana", "Maria")));
        listaPessoas.add(new Pessoa("Carlos", Arrays.asList("Ana")));
        listaPessoas.add(new Pessoa("Joao", Arrays.asList("Ana", "Luiza")));
        listaPessoas.add(new Pessoa("Luiza", Arrays.asList("Joao")));
    }

    @GetMapping("/pessoas")
    public List getPessoas(){
        return service.getPerson(listaPessoas);
    }

    @PostMapping("/pessoas")
    public String cadastraPessoa(@RequestBody Pessoa pessoa){
        return service.cadastraPerson(pessoa, listaPessoas);
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa getPessoa(@PathVariable("id") int id) {
        return service.getPersonById(id, listaPessoas);
    }

    @GetMapping("/pessoas/conhecidas/{nome}")
    public List<String> getConhecidosDeAlguem(@PathVariable("nome") String nome){
        return service.getSomeoneFriends(nome, listaPessoas);
    }

    @GetMapping("/pessoas/desconhecidas/{nome}")
    public List<String> getPessoasRelacionadas(@PathVariable("nome") String nome) {
        try{
            return service.getRelatedPerson(nome, listaPessoas);
        }
        catch(Exception e){
            return Arrays.asList(
                                "Falha ao buscar pessoa.",
                                "Mensagem: " + e.getMessage(),
                                "Cause: " + e.getCause(),
                                "Stacktrace: " + e.getStackTrace()
                                );
        }
    }
}