package Model;

public class OperacaoVenda {

    private int idOperacaoVenda;

    private int Vendedores_idVendedores;

    private int Cliente_CPF;

    public OperacaoVenda(int idOperacaoVenda, int vendedores_idVendedores, int cliente_CPF) {
        this.idOperacaoVenda = idOperacaoVenda;
        Vendedores_idVendedores = vendedores_idVendedores;
        Cliente_CPF = cliente_CPF;
    }

    public int getIdOperacaoVenda() {
        return idOperacaoVenda;
    }

    public int getVendedores_idVendedores() {
        return Vendedores_idVendedores;
    }

    public int getCliente_CPF() {
        return Cliente_CPF;
    }
}
