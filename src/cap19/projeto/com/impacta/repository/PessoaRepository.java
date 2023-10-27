package cap19.projeto.com.impacta.repository;

import cap19.projeto.com.impacta.exception.PessoaException;
import cap19.projeto.com.impacta.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements PessoaRepositoryInterface {
    @Override
    public Pessoa save(Pessoa pessoa) {

        String queryInserirSql = "INSERT INTO db_impacta.tb_pessoa (nome, cpf) VALUES (? ,?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryInserirSql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("OBJETO SALVO COM SUCESSO...");
                ResultSet primaryKeys = preparedStatement.getGeneratedKeys();
                if (primaryKeys.next()) {
                    int idPessoa = primaryKeys.getInt(1);
                    return new Pessoa(idPessoa, pessoa.getNome(), pessoa.getCpf());
                }
            }
            throw new PessoaException("NÃO FOI POSSÍVEL SALVAR OBJETO: " + pessoa);
        } catch (SQLException | PessoaException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Pessoa findByIdPessoa(int idPessoa) {

        String queryBuscarSql = "SELECT * FROM db_impacta.tb_pessoa WHERE ID_PESSOA = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryBuscarSql)) {

            preparedStatement.setInt(1, idPessoa);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getPessoa(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Pessoa findByCpf(String cpf) {

            String queryBuscarSql = "SELECT * FROM db_impacta.tb_pessoa WHERE CPF = ?";

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(queryBuscarSql)) {

                preparedStatement.setString(1, cpf);

                ResultSet resultSet = preparedStatement.executeQuery();

               return getPessoa(resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public List<Pessoa> findByNome(String nome) { return null; }

    @Override
    public List<Pessoa> findByAll() {

        String queryBuscarSql = "SELECT * FROM db_impacta.tb_pessoa";

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(queryBuscarSql);

            // TODO: 26/10/2023 preciso pegar cada linha data tabela
            // TODO: 26/10/2023 add em uma lista e retornar os objetos

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return new ArrayList<>();
    }


    @Override
    public Pessoa update(Pessoa pessoa) {
        return null;
    }
    @Override
    public int delete(int idPessoa) {
        return 0;
    }


    private Connection getConnection() throws SQLException {
        // Extrair para uma classe abstrata essa conexão
        String usuario = "root";
        String senha = "root";
        String URL_DB_IMPACTA = "jdbc:mysql://localhost:3306/db_impacta?useTimezone=true&serverTimezone=UTC";

        return DriverManager.getConnection(URL_DB_IMPACTA, usuario, senha);
    }

    private Pessoa getPessoa(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            int id_pessoa = resultSet.getInt("ID_PESSOA");
            String nome = resultSet.getString("NOME");
            String cpf = resultSet.getString("CPF");

            return new Pessoa(id_pessoa, nome, cpf);
        }
        return null;
    }
}
