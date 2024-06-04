package Model;

public class Vendedores {

    private int idVendedores;

    private String Nome;

    public Vendedores(int id, String nome) {
        this.idVendedores = id;
        this.Nome = nome;
    }

    public int getId() {
        return idVendedores;
    }

    public String getNome() {
        return Nome;
    }
}
