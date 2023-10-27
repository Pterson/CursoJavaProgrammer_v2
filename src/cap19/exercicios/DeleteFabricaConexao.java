package cap19.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFabricaConexao {

    public static void main(String[] args) {

        String URL_DB_IMPACTA = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";

        Connection connection = null;

        try{
           connection = DriverManager.getConnection(URL_DB_IMPACTA, usuario, senha);

            System.out.println();
            System.out.println("--------------------");
            System.out.println("-- CONEXÃO EM USO --");
            System.out.println("--------------------");


            String queryDeletarSql = "DELETE FROM db_impacta.tb_pessoa WHERE ID_PESSOA = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(queryDeletarSql);

            preparedStatement.setInt(1, 2);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println();
                System.out.println("*********************");
                System.out.println("EXCLUSÃO CONCLUÍDA!!!");
                System.out.println("*********************");
            } else {
                System.out.println();
                System.out.println("********************");
                System.out.println("FALHA NA EXCLUSÃO...");
                System.out.println("********************");
            }

        } catch (SQLException e) {
            if (connection == null) {
            System.out.println("PROBLEMA NA CONEXÃO...");
           }
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                    System.out.println();
                    System.out.println("---------------------");
                    System.out.println("CONEXÃO FINALIZADA!!!");
                    System.out.println("---------------------");
                } catch (SQLException e) {
                    System.out.println();
                    System.out.println("--------------------------");
                    System.out.println("FALHA AO FECHAR CONEXÃO!!!");
                    System.out.println("--------------------------");
                    e.printStackTrace();
                }
            }
        }

    }
}
