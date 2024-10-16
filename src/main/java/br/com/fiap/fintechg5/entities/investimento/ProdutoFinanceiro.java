package br.com.fiap.fintechg5.entities.investimento;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ProdutoFinanceiro {
    private Long id;
    private Long investimentoId;
    private String tipoProdutoFinanceiro;
    private String descricao;
    private String nomeInstituicaoFinanceira;
    private LocalDate dataFinal;

    public ProdutoFinanceiro() {}

    public ProdutoFinanceiro(Long id, Long investimentoId, String tipoProdutoFinanceiro, String descricao,
                             String nomeInstituicaoFinanceira, LocalDate dataFinal) {
        this.id = id;
        this.investimentoId = investimentoId;
        this.tipoProdutoFinanceiro = tipoProdutoFinanceiro;
        this.descricao = descricao;
        this.nomeInstituicaoFinanceira = nomeInstituicaoFinanceira;
        this.dataFinal = dataFinal;
    }
}
