package br.com.fiap.fintechg5.view.metafinanceira;

import br.com.fiap.fintechg5.dao.metafinanceira.MetaFinanceiraDao;

public class DeleteMetaFinanceira {
    public static void main(String[] args) {
        try {
            MetaFinanceiraDao dao = new MetaFinanceiraDao();
            dao.deleteById(1L);
            System.out.println("Meta financeira excluída com sucesso!");
            dao.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
