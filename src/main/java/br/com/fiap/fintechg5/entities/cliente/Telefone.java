package br.com.fiap.fintechg5.entities.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Telefone {
    private Long id;
    private Long idCliente;
    private Integer ddi;
    private Integer ddd;
    private String numeroTelefone;
    private String tipoContato;
    private Boolean active;
}
