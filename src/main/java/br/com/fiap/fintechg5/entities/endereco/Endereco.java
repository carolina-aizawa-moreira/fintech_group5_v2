package br.com.fiap.fintechg5.entities.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {
    private Long id;
    private Long idCliente;
    private Long idCidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
}
