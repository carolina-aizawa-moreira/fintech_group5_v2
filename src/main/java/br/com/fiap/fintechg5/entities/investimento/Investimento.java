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
                        String dataInicial, String dataFinal) {
        this.id = id;
        this.idCliente = idCliente;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.dataInicial = LocalDate.parse(dataInicial.substring(0,10));
        this.dataFinal = LocalDate.parse(dataFinal.substring(0,10));
    }

    public Investimento () {}
}
