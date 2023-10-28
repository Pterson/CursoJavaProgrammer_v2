package cap19.projeto.com.impacta.service;

import cap19.projeto.com.impacta.exception.PessoaException;
import cap19.projeto.com.impacta.model.Pessoa;
import cap19.projeto.com.impacta.repository.PessoaRepository;

import java.util.List;

public class PessoaService {
    private final PessoaRepository pessoaRepository;
    public PessoaService() {
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa salvar(Pessoa pessoa) {

        if(pessoa.getNome() != null && pessoa.getCpf() != null) {
            System.out.println("Pessoa Service");

            pessoaRepository.save(pessoa);

            return pessoa;
        }

        throw new PessoaException("O objeto contém dados nulos" +
                " Nome: " + pessoa.getNome() + " CPF " + pessoa.getCpf());

    }
    public Pessoa buscarPessoa(int idPessoa) {
        return pessoaRepository.findByIdPessoa(idPessoa);
    }

    public Pessoa buscarCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public List<Pessoa> buscarTodos() { return pessoaRepository.findByAll(); }
    public void excluir(int idPessoa) {
        int linhasExcluidas = pessoaRepository.delete(idPessoa);
        if (linhasExcluidas == 0) {
            throw new PessoaException("Não foi possivel excluir, pessoa com ID: " + idPessoa);
        }
    }

    public Pessoa atualizar(Pessoa pessoa) {
        Pessoa pessoaEntity = buscarPessoa(pessoa.getIdPessoa());

        if (pessoaEntity != null) {
            Pessoa pessoaCpf = this.buscarCpf(pessoa.getCpf());

            if (pessoaCpf == null || pessoaCpf.getIdPessoa() == pessoaEntity.getIdPessoa()) {
                pessoaEntity = pessoaRepository.update(pessoa);
                return pessoaEntity;
            }
            return pessoaCpf;
        }
        return null;
    }



}
