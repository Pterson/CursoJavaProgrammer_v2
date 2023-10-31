//package cap19.projeto.com.impacta.test;
//
//import cap19.projeto.com.impacta.controller.PessoaController;
//import cap19.projeto.com.impacta.exception.PessoaException;
//import cap19.projeto.com.impacta.model.Pessoa;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Objects;
//
//public class PessoaControllerTest {
//
//    private static PessoaController pessoaController;
//
//@BeforeAll
//static void start() {
//    pessoaController = new PessoaController();
//    }
//    @Test // Teste Positivo
//    void cadastrarPessoaTeste() {
//
//        Pessoa pessoa = new Pessoa("Peterson", "12345678910");
//        System.out.println("TEST: Objeto PESSOA criado" + pessoa);
//        Pessoa pessoaEntity = pessoaController.cadastrar(pessoa);
//        System.out.println("TEST: Metodo SALVAR executado");
//        Assertions.assertNotNull(pessoaEntity);
//    }
//    @Test // Teste Negativo
//    void cadastrarPessoaDadosTeste() {
//
//        Pessoa pessoa = new Pessoa("Peterson", null);
//
//        Assertions.assertThrows(PessoaException.class,
//                () -> pessoaController.cadastrar(pessoa));
//    }
//
//
//    @Test
//    void buscarPessoaPorIdValido() {
//    int idPessoa = 3;
//
//    Pessoa pessoaEntity = pessoaController.buscarPessoa(idPessoa);
//
//    Assertions.assertNotNull(pessoaEntity);
//    Assertions.assertTrue(idPessoa == pessoaEntity.getIdPessoa());
//    }
//    @Test
//    void buscarPessoaPorIdInvalido() {
//        int idPessoa = 3;
//
//        Pessoa pessoaEntity = pessoaController.buscarPessoa(idPessoa);
//        Assertions.assertNull(pessoaEntity);
//    }
//
//
//    @Test
//    void buscarPessoaPorCpfValido() {
//        String cpf = "12345678911";
//
//        Pessoa pessoaEntity = pessoaController.buscarCpf(cpf);
//
//        Assertions.assertNotNull(pessoaEntity);
//        Assertions.assertTrue(cpf.equals(pessoaEntity.getCpf()));
//    }
//    @Test
//    void buscarPessoaPorCpfNull() {
//        String cpf = "12345678911";
//
//        Pessoa pessoaEntity = pessoaController.buscarCpf(cpf);
//
//        Assertions.assertNull(pessoaEntity);
//
//        System.out.println("O CPF não é nulo!!!");
//    }
//
//    @Test
//    void buscarListaPessoa() {
//
//        List<Pessoa> pessoas = pessoaController.buscarTodos();
//
//        Assertions.assertTrue(pessoas.isEmpty());
//    }
//
//    @Test
//    void excluirIdPessoa() {
//        try {
//            int idPessoa = 5;
//            pessoaController.excluir(idPessoa);
//            Pessoa pessoa = pessoaController.buscarPessoa(idPessoa);
//            //Assertions.assertTrue(pessoa == null);
//            Assertions.assertNull(pessoa);
//            System.out.println("Exclusão Efetuada!!!");
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            Assertions.assertTrue(e instanceof PessoaException);
//        }
//    }
//
//    @Test
//    void atualizarNomeCorreto() {
//        Pessoa pessoa = new Pessoa(1, "LEOA", "98765432110");
//
//        Pessoa pessoaEntity = pessoaController.atualizar(pessoa);
//        Assertions.assertNotNull(pessoaEntity);
//        Assertions.assertEquals(pessoa.getNome(), pessoaEntity.getNome());
//
//        System.out.println("O nome está correto!!!");
//    }
//
//    @Test
//    void validaCpfDuplicado() {
//        Pessoa pessoa = new Pessoa(1, "LEOA", "98765432110");
//
//        Pessoa pessoaEntity = pessoaController.atualizar(pessoa);
//        Assertions.assertNotNull(pessoaEntity);
//        Assertions.assertEquals(pessoa.getCpf(), pessoaEntity.getCpf());
//
//    }
//
//}
