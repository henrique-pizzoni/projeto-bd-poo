package Model;

public class NotasFiscais {

    private int idNotasFiscais;

    private int OperacaoVenda_idOperacaoVenda;

    public NotasFiscais(int idNotasFiscais, int operacaoVenda_idOperacaoVenda) {
        this.idNotasFiscais = idNotasFiscais;
        OperacaoVenda_idOperacaoVenda = operacaoVenda_idOperacaoVenda;
    }

    public int getIdNotasFiscais() {
        return idNotasFiscais;
    }

    public int getOperacaoVenda_idOperacaoVenda() {
        return OperacaoVenda_idOperacaoVenda;
    }


}
