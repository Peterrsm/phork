package com.pedro.fork.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pessoa {
    String nome;
    List<String> connections;

    public Pessoa(String nome, List<String> connections) {
        this.nome = nome;
        this.connections = connections;
    }
}
