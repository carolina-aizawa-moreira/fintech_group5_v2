package br.com.fiap.fintechg5.entities.despesa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Despesa {
    private int id;
    private int idCliente;
    private String categoria;
    private String descricao;
    private double valor;
    private boolean emprestimo;

    public Despesa() {}
}
