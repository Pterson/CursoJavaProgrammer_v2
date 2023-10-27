package cap19.projeto.com.impacta.repository;

import cap19.projeto.com.impacta.model.Pessoa;

import java.util.List;

public interface PessoaRepositoryInterface {
    //CREATE
    Pessoa save(Pessoa pessoa);

    // READ
    Pessoa findByIdPessoa(int idPessoa);
    Pessoa findByCpf(String cpf);
    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByAll();

    // UPDATE
    Pessoa update(Pessoa pessoa);

    // DELETE
    int delete(int idPessoa);
}
