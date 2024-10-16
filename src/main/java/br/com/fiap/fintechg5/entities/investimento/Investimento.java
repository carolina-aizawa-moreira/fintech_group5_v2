package br.com.fiap.fintechg5.entities.investimento;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Investimento {
    private Long id;
    private Long idCliente;
    private String tipoInvestimento;
    private double valorInvestido;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public Investimento(long id, long idCliente, String tipoInvestimento, double valorInvestido,
                        LocalDate dataInicial, LocalDate dataFinal) {
        this.id = id;
        this.idCliente = idCliente;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Investimento () {}
}
