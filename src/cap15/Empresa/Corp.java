package cap15.Empresa;

import java.util.*;

public class Corp{

    private String nome;
    private Map<Integer, Produto> produtoMap = new HashMap<>();

    public Corp(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Integer, Produto> getProdutoMap() {
        return produtoMap;
    }

    public void setProdutoMap(Map<Integer, Produto> produtoMap) {
        this.produtoMap = produtoMap;
    }

    public void adicionarProduto(Produto produto) {
        this.produtoMap.put(produto.getCodigo(), produto);
    }

    public void excluirProduto(Integer codigo) {
        this.produtoMap.remove(codigo);
    }

    public Set<Integer> retornarListaCodigo() {
        return this.produtoMap.keySet();
    }

    public List<Produto> retornarListaProduto() {
        return new ArrayList<>(this.produtoMap.values());
    }

    public Integer tamanhoListaProdutos() {
        return this.produtoMap.size();
    }

    public boolean existeProduto(Integer codigo) {
        return this.produtoMap.containsKey(codigo);
    }
}