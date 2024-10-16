package br.com.fiap.fintechg5.view.cliente.despesa;

import br.com.fiap.fintechg5.dao.despesa.DespesaDao;
import br.com.fiap.fintechg5.entities.despesa.Despesa;

import java.sql.SQLException;
import java.util.List;

public class GetAllDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();
            List<Despesa> list = dao.getAll();

            list.forEach(desp -> System.out.printf("id: %d, id_cliente: %d, categoria: %s, descricao: %s, valor: %.2f, " +
                    "emprestimo: %b\n", desp.getId(), desp.getIdCliente(), desp.getCategoria(), desp.getDescricao(),
                    desp.getValor(), desp.isEmprestimo()));

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

