package DAO;
import Model.OperacaoVenda;

import java.sql.SQLException;
import java.util.ArrayList;

public class OperacaoVendaDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertOperacao(OperacaoVenda operacao) {
        connectToDB();
        String sql = "INSERT INTO OperacaoVenda (idOperacaoVenda,Vendedores_idVendedores,Cliente_CPF) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, operacao.getIdOperacaoVenda());
            pst.setInt(2, operacao.getVendedores_idVendedores());
            pst.setInt(3, operacao.getCliente_CPF());
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
    public boolean updateOperacao(int id, OperacaoVenda operacao) {
        connectToDB();
        String sql = "UPDATE OperacaoVenda SET idOperacaoVenda=?, Vendedores_idVendedores=?, Cliente_CPF=?  where idOperacaoVenda=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, operacao.getIdOperacaoVenda());
            pst.setInt(2, operacao.getVendedores_idVendedores());
            pst.setInt(3, operacao.getCliente_CPF());
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
    public boolean deleteOperacao(int id) {
        connectToDB();
        String sql = "DELETE FROM OperacaoVenda where idOperacaoVenda=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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
    public ArrayList<OperacaoVenda> selectOperacao() {
        ArrayList<OperacaoVenda> operacoes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM OperacaoVenda";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Operações: ");
            while (rs.next()) {
                OperacaoVenda opAux = new OperacaoVenda(rs.getInt("idOperacaoVenda"), rs.getInt("Vendedores_idVendedores"), rs.getInt("Cliente_CPF"));
                System.out.println("idOperacao = " + opAux.getIdOperacaoVenda());
                System.out.println("idVendedor = " + opAux.getVendedores_idVendedores());
                System.out.println("CPF_Cliente = " + opAux.getCliente_CPF());
                System.out.println("--------------------------------");
                operacoes.add(opAux);
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
        return operacoes;
    }



}
