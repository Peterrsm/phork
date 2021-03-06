package com.pedro.fork.service;

import com.pedro.fork.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    public List getPerson(List<Pessoa>listaPessoas){
        List<String> nomes = new ArrayList<>();

        for (Pessoa item: listaPessoas) {
            nomes.add(item.getNome());
        }
        return nomes;
    }

    public String cadastraPerson(Pessoa pessoa, List<Pessoa> listaPessoas){
        Pessoa nova = new Pessoa(pessoa.getNome(), pessoa.getConnections());
        String check = checkConhecidos(pessoa.getConnections(), listaPessoas);

        if(check.equals("")){
            listaPessoas.add(nova);
            return "Cadastro efetuado com sucesso!";
        }
        return check;
    }

    public Pessoa getPersonById(int id, List<Pessoa>listaPessoas) {
        return listaPessoas.get(id);
    }

    public List<String> getSomeoneFriends(String nome, List<Pessoa>listaPessoas){
        int ref =  listaPessoas.indexOf(nome);

        List<Pessoa> result = listaPessoas.stream()
                .filter(Pessoa -> Pessoa.getNome().equals(nome))
                .collect(Collectors.toList());

        return result.get(0).getConnections();
    }

    public List<String> getRelatedPerson(String nome, List<Pessoa>listaPessoas){
        List<String> relacionados = null;
        List<String> friends = null;
        List<String> unknown = new ArrayList<>();

        friends = getRelated(nome, listaPessoas);

        for (String person: friends) {
            relacionados = getRelated(person, listaPessoas);

            for (String val : relacionados) {
                if(!friends.contains(val) && relacionados.contains(val) && !val.contains(nome) && !unknown.contains(val))
                    unknown.add(val);
            }
        }

        return unknown;
    }

    public String checkConhecidos(List<String> conhecidos, List<Pessoa> listaPessoas){
        String retorno = "";
        List pessoas = getPerson(listaPessoas);

        for (String conhecido: conhecidos) {
            if(!pessoas.contains(conhecido))
                retorno += "Pessoa " + conhecido + " n??o existe\n";
        }
        return retorno;
    }

    private List<String> getRelated(String nomePessoa, List<Pessoa>listaPessoas){
        List<Pessoa> pessoa = listaPessoas.stream()
                .filter(Pessoa -> Pessoa.getNome().equals(nomePessoa))
                .collect(Collectors.toList());

        return pessoa.get(0).getConnections();
    }
}
