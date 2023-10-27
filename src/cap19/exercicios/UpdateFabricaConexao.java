package cap19.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFabricaConexao {

    public static void main(String[] args) {

        String URL_DB_IMPACTA = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";

        String queryAtualizarSql = "UPDATE db_impacta.tb_pessoa " +
                "SET NOME = ?" +
                "WHERE (ID_PESSOA = ?)";

        try (Connection connection = DriverManager.getConnection(URL_DB_IMPACTA, usuario, senha);
            PreparedStatement preparedStatement = connection.prepareStatement(queryAtualizarSql)) {


            System.out.println();
            System.out.println("--------------------");
            System.out.println("-- CONEXÃO EM USO --");
            System.out.println("--------------------");


            preparedStatement.setString(1, "ryu".toUpperCase());
            preparedStatement.setInt(2,4);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println();
                System.out.println("*************************");
                System.out.println("ATUALIZADO COM SUCESSO!!!");
                System.out.println("*************************");
            } else {
                System.out.println();
                System.out.println("**********************");
                System.out.println("FALHA NA ATUALIZADO...");
                System.out.println("**********************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
