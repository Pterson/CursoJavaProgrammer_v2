package cap19.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String usuario = "root";
        String senha = "root";
        String URL_DB_IMPACTA = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";

        try {
            Connection connection = DriverManager.getConnection(usuario, senha, URL_DB_IMPACTA);
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            }
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
        }
    }
}

