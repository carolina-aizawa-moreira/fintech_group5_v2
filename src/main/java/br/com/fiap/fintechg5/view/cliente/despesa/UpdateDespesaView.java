package br.com.fiap.fintechg5.view.cliente.despesa;

import br.com.fiap.fintechg5.dao.despesa.DespesaDao;
import br.com.fiap.fintechg5.entities.despesa.Despesa;

import java.sql.SQLException;

public class UpdateDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();

            Despesa despesa = new Despesa();
            despesa.setCategoria("Alimentação");
            despesa.setDescricao("Refeição no restaurante");
            despesa.setValor(150.00);
            despesa.setEmprestimo(false);

            dao.update(despesa);
            dao.closeConnection();
            System.out.println("Despesa atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

