package br.com.fiap.fintechg5.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
//    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe" ;
//    private static final String USER = "system";
//    private static final String PASSWORD = "root";

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USER = " rm559207";
    private static final String PASSWORD = "250805";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexao feita com sucesso!");

        return connection;

    }
}
