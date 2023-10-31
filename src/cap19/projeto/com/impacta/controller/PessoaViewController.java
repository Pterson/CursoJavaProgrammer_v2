package cap19.projeto.com.impacta.controller;

import cap19.projeto.com.impacta.model.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoaViewController implements ActionListener {

    JTextField idPessoaRecebido;
    JTextField nomeRecebido;
    JTextField cpfRecebido;
    JFrame frameCadastrarPessoaRecebido;

    public PessoaViewController(JTextField idPessoaRecebido, JTextField nomeRecebido, JTextField cpfRecebido, JFrame frameCadastrarPessoaRecebido) {
        this.idPessoaRecebido = idPessoaRecebido;
        this.nomeRecebido = nomeRecebido;
        this.cpfRecebido = cpfRecebido;
        this.frameCadastrarPessoaRecebido = frameCadastrarPessoaRecebido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frameCadastrarPessoaRecebido.setVisible(false);
    }

    public Pessoa popularPessoa() {
        Pessoa pessoa = new Pessoa();

        pessoa.setIdPessoa(Integer.parseInt(idPessoaRecebido.getText()));
        pessoa.setNome(nomeRecebido.getText());
        pessoa.setCpf(cpfRecebido.getText());

        return pessoa;
    }
}
