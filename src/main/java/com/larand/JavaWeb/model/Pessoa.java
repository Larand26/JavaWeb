package com.larand.JavaWeb.model;

public class Pessoa {
    private Integer idade;
    private String nome;
    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
