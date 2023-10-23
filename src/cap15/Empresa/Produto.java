package cap15.Empresa;

public class Produto {

    private Integer codigo;
    private String nome;
    private Integer quantidade;
    private Integer qtdMinima;

    public Produto(Integer codigo, String nome, Integer quantidade, Integer qtdMinima) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.qtdMinima = qtdMinima;
    }

    public Produto() {}

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Integer getQtdMinima() {
        return qtdMinima;
    }
    public void setQtdMinima(Integer qtdMinima) {
        this.qtdMinima = qtdMinima;
    }
    public Integer adicionarQuantidadeProduto(Integer quantidade) {
        return this.quantidade += quantidade;
    }

    public Number subtrairQuantidade(Integer quantidade) {
        int resultado = this.quantidade - quantidade;
        if(resultado >= 0) {
            this.quantidade = resultado;
            return this.quantidade;
        }
        throw new RuntimeException("Quantidade " + quantidade + " é superior ao estoque informado, estoque: " + this.quantidade);
    }
    public boolean qtdMinima() {
        return quantidade <= qtdMinima;
    }

    @Override
    public String toString() {
        return "Produto{" +
        "codigo=" + codigo +
        ", nome='" + nome + '\'' +
        ", quantidade=" + quantidade +
        ", qtdMinima=" + qtdMinima +
        '}';
    }
}
