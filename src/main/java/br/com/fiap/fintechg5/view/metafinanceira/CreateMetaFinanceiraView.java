package br.com.fiap.fintechg5.view.metafinanceira;

import br.com.fiap.fintechg5.commons.StatusMetaFinanceira;
import br.com.fiap.fintechg5.dao.metafinanceira.MetaFinanceiraDao;
import br.com.fiap.fintechg5.entities.metafinanceira.MetaFinanceira;

import java.time.LocalDate;

public class CreateMetaFinanceiraView {
    public static void main(String [] args) {
        try {
            MetaFinanceiraDao dao = new MetaFinanceiraDao();

            MetaFinanceira createdMetaFinanceira = MetaFinanceira.builder()
                    .idCliente(22L)
                    .metaFinanceira("Meta Financeira teste")
                    .valorMetaFinanceira(1500.0)
                    .status(StatusMetaFinanceira.EM_ANDAMENTO.name())
                    .descricao("Meta criada para teste de insert")
                    .dataMetaCriada(LocalDate.now())
                    .dataMetaConclusao(LocalDate.of(2025,1,31))
                    .build();

            dao.create(createdMetaFinanceira);
            dao.closeConnection();
            System.out.println("Meta Financeira criada!");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
