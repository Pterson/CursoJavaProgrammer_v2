package cap19.exercicios;

import javax.swing.*;
import java.sql.*;

public class InsertFabricaConexao {

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

            String queryInserirSql = "INSERT INTO db_impacta.tb_pessoa (NOME, CPF, ID_PESSOA) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(queryInserirSql);

            String NOME = "yuri";
            preparedStatement.setString(1, NOME.toUpperCase());

            String CPF = "12345678915";
            preparedStatement.setString(2, CPF);

            int ID_PESSOA = 5;
            preparedStatement.setInt(3,ID_PESSOA);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println();
                System.out.println("***********************");
                System.out.println("INSERIDO COM SUCESSO!!!");
                System.out.println("***********************");
            } else {
                System.out.println();
                System.out.println("********************");
                System.out.println("FALHA NA INSERÇÃO...");
                System.out.println("********************");
            }


        } catch (SQLException e) {
            if (connection == null) {
            System.out.println("PROBLEMA NA CONEXÃO...");
           }
            e.printStackTrace();
        }

    }
}
