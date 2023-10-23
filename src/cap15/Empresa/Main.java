package cap15.Empresa;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {

        Corp ptech = new Corp("P-tech");

        ptech.adicionarProduto(new Produto(1234, "leite", 100, 10));
        ptech.adicionarProduto(new Produto(1235, "pão", 400, 100));
        ptech.adicionarProduto(new Produto(1236, "ovo", 300, 100));
        ptech.adicionarProduto(new Produto(1237, "Leite em pó", 500, 100));
        ptech.adicionarProduto(new Produto(1238, "Banana", 600, 100));

        ptech.getNome();
        ptech.getProdutoMap().forEach((key, value) -> {
            System.out.print(key + " ");
            System.out.println(value);
        });

        ptech.excluirProduto(1237);

        System.out.println("Após exclusão do produto de código 1237");
        ptech.getProdutoMap().forEach((key, value) -> {
            System.out.println(key + " ");
            System.out.println(value);
        });

        System.out.println("Lista somente chaves");
        ptech.retornarListaCodigo().forEach(codigo -> System.out.println(codigo));

        System.out.println("Lista somente valores");
        ptech.retornarListaProduto().forEach(produto -> System.out.println(produto));

        System.out.println("Quantidade de produtos na empresa: " + ptech.tamanhoListaProdutos());

        System.out.println("Existe um produto com o código: 1237 " + ptech.existeProduto(1234));
    }
}
