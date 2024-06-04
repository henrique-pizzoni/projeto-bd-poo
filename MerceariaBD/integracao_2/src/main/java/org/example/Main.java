package org.example;
import DAO.*;
import Model.*;

public class Main {
    public static void main(String[] args) {

        //Insert, update e select nos clientes
        Clientes c1 = new Clientes(223802223, "Jose", "3323-4423");
        Clientes c2 = new Clientes(33131234, "Maria", "3312-4420");
        Clientes c3 = new Clientes(000011123,"Marquinhos","9913-2234");
        Clientes c4 = new Clientes(111222333,"Josefina","4002-8922");

        ClienteDAO caux = new ClienteDAO();

        caux.insertClientes(c1);
        caux.insertClientes(c2);
        caux.insertClientes(c3);

        caux.updateClientes(000011123, c4);


        caux.selectCliente();


        //Insert e select nos vendedores
        Vendedores v1 = new Vendedores(1,"Jonas");
        Vendedores v2 = new Vendedores(2,"Molenga");
        Vendedores v3 = new Vendedores(3, "Josias");
        VendedoresDAO vaux = new VendedoresDAO();

        vaux.insertVendedor(v1);
        vaux.insertVendedor(v2);
        vaux.insertVendedor(v3);

        vaux.selectVendedor();


        //Insert e select nas operações de venda
        OperacaoVendaDAO operacaoVendaControle = new OperacaoVendaDAO();
        OperacaoVenda o1 = new OperacaoVenda(1, v1.getId(),c1.getCPF());
        OperacaoVenda o2 = new OperacaoVenda(2, v2.getId(), c2.getCPF());
        OperacaoVenda o3 = new OperacaoVenda(3, v3.getId(), c2.getCPF());

        operacaoVendaControle.insertOperacao(o1);
        operacaoVendaControle.insertOperacao(o2);
        operacaoVendaControle.insertOperacao(o3);

        operacaoVendaControle.selectOperacao();


        //Insert e select nas notas fiscais
        NotasFiscaisDAO notaAux = new NotasFiscaisDAO();

        NotasFiscais n1 = new NotasFiscais(1,o1.getIdOperacaoVenda());
        NotasFiscais n2 = new NotasFiscais(2, o2.getIdOperacaoVenda());
        NotasFiscais n3 = new NotasFiscais(3, o3.getIdOperacaoVenda());

        notaAux.insertNota(n1);
        notaAux.insertNota(n2);
        notaAux.insertNota(n3);

        notaAux.selectNotas();


        //Insert, delete e select nos produtos
        ProdutoDAO prodAux = new ProdutoDAO();

        Produtos p1 = new Produtos(1, 30, "Maçã");
        Produtos p2 = new Produtos(2,20,"Banana");
        Produtos p3 = new Produtos(3, 50, "Leite");

        prodAux.insertProduto(p1);
        prodAux.insertProduto(p2);
        prodAux.insertProduto(p3);

        prodAux.deleteProdutos(2);

        prodAux.selectProduto();




        //Insert no relacionamento de operacao com produtos
        OperacaoVenda_ProdutoDAO opAux = new OperacaoVenda_ProdutoDAO();


        OperacaoVenda_Produtos op1 = new OperacaoVenda_Produtos(o1.getIdOperacaoVenda(), p1.getIdProdutos());

        opAux.insertOP_Produto(op1);

        opAux.selectProduto();


    }
}