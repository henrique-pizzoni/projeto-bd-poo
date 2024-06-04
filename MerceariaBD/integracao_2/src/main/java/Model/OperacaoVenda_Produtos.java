package Model;

public class OperacaoVenda_Produtos {
    private int OperacaoVenda_idOperacaoVenda;

    private int Produtos_idProduto;

    public OperacaoVenda_Produtos(int operacaoVenda_idOperacaoVenda, int produtos_idProduto) {
        OperacaoVenda_idOperacaoVenda = operacaoVenda_idOperacaoVenda;
        Produtos_idProduto = produtos_idProduto;
    }

    public int getOperacaoVenda_idOperacaoVenda() {
        return OperacaoVenda_idOperacaoVenda;
    }

    public int getProdutos_idProduto() {
        return Produtos_idProduto;
    }


}
