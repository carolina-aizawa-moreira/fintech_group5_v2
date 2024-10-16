package br.com.fiap.fintechg5.entities.conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoFinanceira {
    private Long id;
    private Long idConta;
    private String tipoTransacao;
    private LocalDate dataTransacao;
    private BigDecimal valorTransacao;
    private String descricao;
    private String statusTransacao;

    public TransacaoFinanceira() {
    }

    public TransacaoFinanceira(Long id, Long idConta, String tipoTransacao, LocalDate dataTransacao, BigDecimal valorTransacao, String descricao, String statusTransacao) {
        this.id = id;
        this.idConta = idConta;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.descricao = descricao;
        this.statusTransacao = statusTransacao;
    }

    public TransacaoFinanceira(String tipoTransacao, LocalDate dataTransacao, BigDecimal valorTransacao, String descricao, String statusTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.descricao = descricao;
        this.statusTransacao = statusTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }
}
