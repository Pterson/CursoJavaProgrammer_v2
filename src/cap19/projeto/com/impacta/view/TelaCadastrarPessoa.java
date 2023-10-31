package cap19.projeto.com.impacta.view;

import cap19.projeto.com.impacta.controller.PessoaController;
import cap19.projeto.com.impacta.controller.PessoaViewController;

import javax.swing.*;

public class TelaCadastrarPessoa {

    public void cadastrarPessoa() {
        int idPessoa = 0;
        String nome = null;
        String cpf = null;

        JFrame frameCadastrarPessoa = new JFrame();
        frameCadastrarPessoa.setSize(600,100);

        JPanel panelCadastrarPessoa = new JPanel();

        JLabel labelIdPessoa = new JLabel("Digite o ID: ");
        panelCadastrarPessoa.add(labelIdPessoa);

        JTextField textIdPessoa = new JTextField(10);
        panelCadastrarPessoa.add(textIdPessoa);


        JLabel labelNome = new JLabel("Digite o nome :");
        panelCadastrarPessoa.add(labelNome);

        JTextField textNome = new JTextField(10);
        panelCadastrarPessoa.add(textNome);


        JLabel labelCpf = new JLabel("Digite o CPF");
        panelCadastrarPessoa.add(labelCpf);

        JTextField textCpf = new JTextField(10);
        panelCadastrarPessoa.add(textCpf);


        JButton salvarCadastroPessoa = new JButton("Salvar");
        panelCadastrarPessoa.add(salvarCadastroPessoa);

        frameCadastrarPessoa.add(panelCadastrarPessoa);
        frameCadastrarPessoa.setVisible(true);


        PessoaViewController pessoaViewController = new PessoaViewController(textIdPessoa, textNome, textCpf, frameCadastrarPessoa);
        salvarCadastroPessoa.addActionListener(pessoaViewController);

    }

}
