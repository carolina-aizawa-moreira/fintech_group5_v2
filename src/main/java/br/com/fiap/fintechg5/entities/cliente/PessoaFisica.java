package br.com.fiap.fintechg5.entities.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PessoaFisica {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private Long idCliente;
}
