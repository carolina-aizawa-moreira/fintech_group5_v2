package br.com.fiap.fintechg5.entities.cliente;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Long id;
    private String username;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String tipoCliente;
    private LocalDate dataCadastro;
    private Boolean active;

    public Cliente(Long id, String username, String dataNascimento, String email, String senha,
                   String tipoCliente, String dataCadastro, Boolean active) {
        this.id = id;
        this.username = username;
        this.dataNascimento = LocalDate.parse(dataNascimento.substring(0,10));
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDate.parse(dataCadastro.substring(0,10));
        this.active = active;
    }
}
