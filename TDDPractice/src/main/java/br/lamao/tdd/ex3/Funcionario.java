package br.lamao.tdd.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Funcionario {
    private String nome;
    private String email;
    @Getter
    private Double salarioBase;
    @Getter
    private CargoEnum cargo;
}
