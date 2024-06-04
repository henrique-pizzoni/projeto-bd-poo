package Model;

public class Produtos {

    private int idProdutos;
    private int Valor;

    private String Nome;

    public Produtos(int idProdutos, int valor, String nome) {
        this.idProdutos = idProdutos;
        Valor = valor;
        Nome = nome;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public int getValor() {
        return Valor;
    }

    public String getNome() {
        return Nome;
    }
}
