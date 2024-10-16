package br.com.fiap.fintechg5.entities.conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Conta {

    private Long id;
    private Long idCliente;
    private BigDecimal saldoConta;
    private String numeroConta;
    private String numeroAgencia;
    private String tipoConta;
    private LocalDate dataAbertura;
    private String statusConta;
    private Boolean ativo;

    public Conta() {
    }

    public Conta(Long id, Long idCliente, BigDecimal saldoConta, String numeroConta, String numeroAgencia, String tipoConta, LocalDate dataAbertura, String statusConta, Boolean ativo) {
        this.id = id;
        this.idCliente = idCliente;
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.tipoConta = tipoConta;
        this.dataAbertura = dataAbertura;
        this.statusConta = statusConta;
        this.ativo = ativo;
    }

    public Conta(BigDecimal saldoConta, String numeroConta, String numeroAgencia, String tipoConta, LocalDate dataAbertura, String statusConta) {
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.tipoConta = tipoConta;
        this.dataAbertura = dataAbertura;
        this.statusConta = statusConta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
