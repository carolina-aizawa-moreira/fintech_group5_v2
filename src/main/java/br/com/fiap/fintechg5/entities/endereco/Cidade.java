package br.com.fiap.fintechg5.entities.endereco;

import br.com.fiap.fintechg5.entities.endereco.commons.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cidade {
    private Long id;
    private String estado;
    private String cep;
    private String cidade;
}
