package br.com.fiap.fintechg5.entities.metafinanceira;

import br.com.fiap.fintechg5.commons.StatusMetaFinanceira;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MetaFinanceira {
    private Long id;
    private Long idCliente;
    private String metaFinanceira;
    private Double valorMetaFinanceira;
    private LocalDate dataMetaCriada;
    private LocalDate dataMetaConclusao;
    private String status;
    private String descricao;

    public MetaFinanceira() {}

    public MetaFinanceira(Long id, Long idCliente, String metaFinanceira, Double valorMetaFinanceira,
                          LocalDate dataMetaCriada, LocalDate dataMetaConclusao, String status,
                          String descricao) {
        this.id = id;
        this.idCliente = idCliente;
        this.metaFinanceira = metaFinanceira;
        this.valorMetaFinanceira = valorMetaFinanceira;
        this.dataMetaCriada = dataMetaCriada;
        this.dataMetaConclusao = dataMetaConclusao;
        this.status = status;
        this.descricao = descricao;
    }
}
