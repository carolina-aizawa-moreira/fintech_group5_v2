package br.com.fiap.fintechg5.view.cliente.despesa;

import br.com.fiap.fintechg5.dao.despesa.DespesaDao;
import br.com.fiap.fintechg5.entities.despesa.Despesa;

public class GetByIdDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();
            int idDespesa = 1;
            Despesa despesa = dao.getById(idDespesa);
            System.out.printf("ID: %d, ID Cliente: %d, Categoria: %s, Descrição: %s, Valor: %.2f, Emprestimo: %b\n",
                    despesa.getId(), despesa.getIdCliente(), despesa.getCategoria(), despesa.getDescricao(),
                    despesa.getValor(), despesa.isEmprestimo());

            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

