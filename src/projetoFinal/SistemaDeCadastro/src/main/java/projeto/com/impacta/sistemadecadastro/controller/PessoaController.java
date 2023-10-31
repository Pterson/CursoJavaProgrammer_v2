package projeto.com.impacta.sistemadecadastro.controller;

import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import projeto.com.impacta.sistemadecadastro.model.Pessoa;
import projeto.com.impacta.sistemadecadastro.service.PessoaService;

import java.net.URL;
import java.util.ResourceBundle;

public class PessoaController implements Initializable {

    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoAlterar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private TableColumn<Pessoa, String> colunaCpf;

    @FXML
    private TableColumn<Pessoa, String> colunaId;

    @FXML
    private TableColumn<Pessoa, String> colunaNome;

    @FXML
    private TableView<Pessoa> table;

    @FXML
    private TextField inputCpf;

    @FXML
    private TextField inputNome;

    PessoaService pessoaService;
    int indexTabela;
    int idPessoa;

    @FXML
    void adicionar(ActionEvent event) {
        System.out.println("Salvando...");

        String nome = inputNome.getText();
        String cpf = inputCpf.getText();

        Pessoa pessoa = new Pessoa(nome.toUpperCase(), cpf);
        Pessoa pessoaEntity = pessoaService.salvar(pessoa);

        Alert alert;

        if(pessoaEntity != null) {
            atualizarTabela();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tela de Cadastro");
            alert.setHeaderText("Cadastro Efetuado");
            alert.setContentText("Processo Finalizado");
            alert.showAndWait();
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tela de Cadastro");
            alert.setHeaderText("Erro No Cadastro");
            alert.setContentText("Cadastro Não realizado");
            alert.showAndWait();
        }

    }

    @FXML
    void alterar(ActionEvent event) {
        String nome = inputNome.getText();
        String cpf = inputCpf.getText();

        Pessoa pessoa = new Pessoa(idPessoa, nome.toUpperCase(), cpf);
        Pessoa pessoaEntity = pessoaService.atualizar(pessoa);

        Alert alert;
        if (pessoaEntity != null) {
            atualizarTabela();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alteração");
            alert.setHeaderText("Alteração ok");
            alert.setContentText("Alterado com sucesso");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alteração");
            alert.setHeaderText("Alteração nok");
            alert.setContentText("Alterado falhou");
            alert.showAndWait();
        }
    }

    @FXML
    void excluir(ActionEvent event) {
        pessoaService.excluir(idPessoa);
        atualizarTabela();
    }

    void atualizarTabela() {
        try {
            ObservableList<Pessoa> pessoas = FXCollections.observableArrayList();
            pessoas.addAll(pessoaService.buscarTodos());

            table.setItems(pessoas);

            colunaId.setCellValueFactory(pessoa -> {
                return new SimpleStringProperty(String.valueOf(pessoa.getValue().getIdPessoa()));
            });

            colunaNome.setCellValueFactory(pessoa -> {
                return new SimpleStringProperty(pessoa.getValue().getNome());
            });

            colunaCpf.setCellValueFactory(pessoa -> {
                return new SimpleStringProperty(pessoa.getValue().getCpf());
            });

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    void linhaSelecionada() {
        table.setRowFactory(pessoaTableView -> {
            TableRow<Pessoa> linha = new TableRow<>();
            linha.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 2 && !linha.isEmpty()) {

                    indexTabela = table.getSelectionModel().getSelectedIndex();

                    idPessoa = table.getItems().get(indexTabela).getIdPessoa();

                    String nome = table.getItems().get(indexTabela).getNome();
                    inputNome.setText(nome);

                    String cpf = table.getItems().get(indexTabela).getCpf();
                    inputCpf.setText(cpf);

                    System.out.printf(idPessoa + nome + cpf);
                }
            });
            return linha;
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pessoaService = new PessoaService();
        atualizarTabela();
        linhaSelecionada();
    }
}