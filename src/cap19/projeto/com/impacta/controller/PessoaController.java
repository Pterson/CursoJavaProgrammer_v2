package cap19.projeto.com.impacta.controller;

import cap19.projeto.com.impacta.model.Pessoa;
import cap19.projeto.com.impacta.service.PessoaService;

import java.util.List;

public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController() {
        pessoaService = new PessoaService();
    }
    public Pessoa cadastrar(Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }
    public Pessoa buscarPessoa(int idPessoa) {
        return pessoaService.buscarPessoa(idPessoa);
    }

    public  Pessoa buscarCpf(String cpf) { return pessoaService.buscarCpf(cpf); }

    public List<Pessoa> buscarTodos() { return pessoaService.buscarTodos(); }


}
