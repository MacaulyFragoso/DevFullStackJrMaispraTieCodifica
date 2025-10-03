package br.com.rh.model;

// Classe de modelo para o Funcionário.
public class Funcionario implements Identificavel<Long> {

    private Long id;
    private String nome;
    private String cargo;

    public Funcionario(Long id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Funcionário [ID=" + id + ", Nome=" + nome + ", Cargo=" + cargo + "]";
    }
}
