package cap19.exercicios;

import javax.xml.transform.Result;
import java.sql.*;

public class FabricaConexao {

    public static void main(String[] args) {

        String URL_DB_IMPACTA = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";

        Connection connection = null;
        try{
           connection = DriverManager.getConnection(URL_DB_IMPACTA, usuario, senha);

            Statement statement = connection.createStatement();

            String queryBuscarSql = "SELECT * FROM db_impacta.tb_pessoa";

            ResultSet resultSet = statement.executeQuery(queryBuscarSql);

            while (resultSet.next()) {
                int ID_PESSOA = resultSet.getInt("ID_PESSOA");
                String NOME = resultSet.getString("NOME");
                String CPF = resultSet.getString("CPF");

                System.out.println("ID_PESSOA: " + ID_PESSOA + " NOME: " + NOME + " CPF: " + CPF);
            }

            System.out.println();
            System.out.println("--------------------");
            System.out.println("-- CONEXÃO EM USO --");
            System.out.println("--------------------");

        } catch (SQLException e) {
            if (connection == null) {
            e.printStackTrace();
            System.out.println("PROBLEMA NA CONEXÃO...");
           }
        }

    }

}
