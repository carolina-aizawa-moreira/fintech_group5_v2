package br.com.fiap.fintechg5.entities.conta;

import java.time.LocalDate;

public class Cartao {
    private Long id;
    private Long idConta;
    private String nomeImpresso;
    private String tipoCartao;
    private String numeroCartao;
    private String cvv;
    private LocalDate dataValidade;
    private String bandeira;
    private Boolean ativo = true;



    public Cartao(Long id, Long idConta, String nomeImpresso, String tipoCartao, String numeroCartao, String cvv, LocalDate dataValidade, String bandeira, Boolean ativo) {
        this.id = id;
        this.idConta = idConta;
        this.nomeImpresso = nomeImpresso;
        this.tipoCartao = tipoCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
        this.bandeira = bandeira;
        this.ativo = ativo;
    }

    public Cartao(String nomeImpresso, String tipoCartao, String numeroCartao, String cvv, LocalDate dataValidade, String bandeira) {
        this.nomeImpresso = nomeImpresso;
        this.tipoCartao = tipoCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
        this.bandeira = bandeira;
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

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
