package br.com.fiap.fintechg5.dao.despesa;

import br.com.fiap.fintechg5.entities.despesa.emprestimo.Emprestimo;
import br.com.fiap.fintechg5.exceptions.NotFoundException;
import br.com.fiap.fintechg5.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class EmprestimoDao {
        private Connection conn;

        public EmprestimoDao() throws SQLException {
            this.conn = ConnectionFactory.getConnection();
        }

        public void closeConnection() throws SQLException {
            conn.close();
        }

        public void create(final Emprestimo emprestimo) throws SQLException {
            String query = "INSERT INTO tb_emprestimo (id_cliente, status, valor, taxa_juro, prazo, data_concessao) VALUES (?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement stm = conn.prepareStatement(query);
                stm.setLong(1, emprestimo.getIdCliente());
                stm.setString(2, emprestimo.getStatus());
                stm.setDouble(3, emprestimo.getValor());
                stm.setDouble(4, emprestimo.getTaxaJuro());
                stm.setInt(5, emprestimo.getPrazo());
                stm.setObject(6, emprestimo.getDataConsessao());

                stm.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public Emprestimo getById(final long id) throws SQLException, NotFoundException {
            String query = "SELECT * FROM tb_emprestimo WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setLong(1, id);

            ResultSet result = stm.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("EMPRÉSTIMO NÃO ENCONTRADO!");
            }

            Long emprestimoId = result.getLong("id");
            Long idCliente = result.getLong("id_cliente");
            String status = result.getString("status");
            double valor = result.getDouble("valor");
            double taxaJuro = result.getDouble("taxa_juro");
            int prazo = result.getInt("prazo");
            LocalDate dataConsessao = result.getDate("data_concessao").toLocalDate();

            return new Emprestimo(emprestimoId, idCliente, status, valor, taxaJuro, prazo, dataConsessao);
        }

        public List<Emprestimo> getAll() throws SQLException {
            String query = "SELECT * FROM tb_emprestimo";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet result = stm.executeQuery();

            List<Emprestimo> list = new ArrayList<>();

            while (result.next()) {
                Long emprestimoId = result.getLong("id");
                Long idCliente = result.getLong("id_cliente");
                String status = result.getString("status");
                double valor = result.getDouble("valor");
                double taxaJuro = result.getDouble("taxa_juro");
                int prazo = result.getInt("prazo");
                LocalDate dataConsessao = result.getDate("data_concessao").toLocalDate();

                list.add(new Emprestimo(emprestimoId, idCliente, status, valor, taxaJuro, prazo, dataConsessao));
            }
            return list;
        }

        public void update(Emprestimo emprestimo) throws SQLException {
            String query = "UPDATE tb_emprestimo SET status = ?  WHERE id = ?";

            PreparedStatement stm = conn.prepareStatement(query);

            stm.setString(1, emprestimo.getStatus());
            stm.setLong(2, emprestimo.getId());
            stm.executeUpdate();
        }

        public void deleteById(final long id) throws SQLException, NotFoundException {
            String query = "DELETE FROM tb_emprestimo WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setLong(1, id);

            int line = stm.executeUpdate();

            if (line == ZERO.intValue()) {
                throw new NotFoundException("Registro nao encontrado!");
            }
        }
}
