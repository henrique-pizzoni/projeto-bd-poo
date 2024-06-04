package DAO;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;


public class OperacaoVenda_ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertOP_Produto(OperacaoVenda_Produtos produto) {
        connectToDB();
        String sql = "INSERT INTO OperacaoVenda_has_Produtos (OperacaoVenda_idOperacaoVenda, Produtos_idProdutos) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, produto.getProdutos_idProduto());
            pst.setInt(2, produto.getOperacaoVenda_idOperacaoVenda());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //UPDATE
    public boolean updateOP_Produto(int id, int id2, OperacaoVenda_Produtos produto) {
        connectToDB();
        String sql = "UPDATE OperacaoVenda_has_Produtos SET OperacaoVenda_idOperacaoVenda=?, Produtos_idProdutos=?, where OperacaoVenda_idOperacaoVenda= " + id + " and Produtos_idProdutos = " + id2;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, produto.getProdutos_idProduto());
            pst.setInt(2, produto.getOperacaoVenda_idOperacaoVenda());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }



    //DELETE
    public boolean deleteProdutos(int id, int id2) {
        connectToDB();
        String sql = "DELETE FROM OperacaoVenda_has_Produtos where OperacaoVenda_idOperacaoVenda=?" + id + " and Produtos_idProdutos=?" + id2;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, id2);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //SELECT
    public ArrayList<OperacaoVenda_Produtos> selectProduto() {
        ArrayList<OperacaoVenda_Produtos> produtos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM OperacaoVenda_has_Produtos";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de OperacaoVenda_has_Produtos: ");
            while (rs.next()) {
                OperacaoVenda_Produtos prodAUX = new OperacaoVenda_Produtos(rs.getInt("OperacaoVenda_idOperacaoVenda"),rs.getInt("Produtos_idProdutos"));
                System.out.println("idOperacaoVenda = " + prodAUX.getOperacaoVenda_idOperacaoVenda());
                System.out.println("idProdutos = " + prodAUX.getProdutos_idProduto());
                System.out.println("--------------------------------");
                produtos.add(prodAUX);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return produtos;
    }
}