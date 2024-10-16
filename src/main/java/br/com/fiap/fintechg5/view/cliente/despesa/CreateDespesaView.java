package br.com.fiap.fintechg5.view.cliente.despesa;

import br.com.fiap.fintechg5.commons.CategoriaDespesa;
import br.com.fiap.fintechg5.dao.despesa.DespesaDao;
import br.com.fiap.fintechg5.entities.despesa.Despesa;

public class CreateDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();
            Despesa despesa = Despesa.builder()
                    .idCliente(1)
                    .categoria(CategoriaDespesa.TRANSPORTE.name())
                    .descricao("Passagem de ônibus")
                    .valor(20.50)
                    .emprestimo(false)
                    .build();

            dao.create(despesa);
            dao.closeConnection();

            System.out.println("Despesa cadastrada com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

