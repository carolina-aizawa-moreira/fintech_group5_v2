package br.com.fiap.fintechg5.entities.despesa.emprestimo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Emprestimo {
    private Long id;
    private Long idCliente;
    private String status;
    private double valor;
    private double taxaJuro;
    private int prazo;
    private LocalDate dataConsessao;

    public Emprestimo() {}

    public Emprestimo(Long id, Long idCliente, String status, double valor, double taxaJuro, int prazo,
                      LocalDate dataConsessao) {
        this.id = id;
        this.idCliente = idCliente;
        this.status = status;
        this.valor = valor;
        this.taxaJuro = taxaJuro;
        this.prazo = prazo;
        this.dataConsessao = dataConsessao;
    }
}
