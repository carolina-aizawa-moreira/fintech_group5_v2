package br.com.fiap.fintechg5.view.metafinanceira;

import br.com.fiap.fintechg5.commons.StatusMetaFinanceira;
import br.com.fiap.fintechg5.dao.metafinanceira.MetaFinanceiraDao;
import br.com.fiap.fintechg5.entities.metafinanceira.MetaFinanceira;

import java.time.LocalDate;

public class GetByIdMetaFinanceiraView {
    public static void main(String [] args) {
        try {
            MetaFinanceiraDao dao = new MetaFinanceiraDao();
            MetaFinanceira metaFinanceira = dao.getById(1L);
            System.out.printf("id: %d, id_cliente: %d, valor_meta_financeira: %.2f, data_conclusao: %tF",
                    metaFinanceira.getId(), metaFinanceira.getIdCliente(), metaFinanceira.getValorMetaFinanceira(),
                    metaFinanceira.getDataMetaConclusao());
            dao.closeConnection();
            System.out.println("\nMeta Financeira encontrada!");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
