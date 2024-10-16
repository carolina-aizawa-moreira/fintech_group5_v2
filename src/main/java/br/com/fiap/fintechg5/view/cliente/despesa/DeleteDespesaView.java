package br.com.fiap.fintechg5.view.cliente.despesa;

import br.com.fiap.fintechg5.dao.despesa.DespesaDao;

public class DeleteDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();
            dao.deleteById(1);
            dao.closeConnection();
            System.out.println("\nDespesa deletada com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

