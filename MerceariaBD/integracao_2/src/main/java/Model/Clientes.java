package Model;

public class Clientes {


    private int CPF;

    private String Nome;

    private String Telefone;

    public Clientes(int CPF, String nome, String telefone) {
        this.CPF = CPF;
        Nome = nome;
        Telefone = telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public String getNome() {
        return Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

}
