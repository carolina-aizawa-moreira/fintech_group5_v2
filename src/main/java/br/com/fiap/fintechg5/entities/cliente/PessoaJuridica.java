package br.com.fiap.fintechg5.entities.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class PessoaJuridica {
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private String ramoAtividade;
    private String inscricaoEstadual;
    private Long idCliente;
}
