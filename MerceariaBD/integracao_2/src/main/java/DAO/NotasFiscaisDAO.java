package DAO;
import Model.NotasFiscais;

import java.sql.SQLException;
import java.util.ArrayList;


public class NotasFiscaisDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertNota(NotasFiscais nota) {
        connectToDB();
        String sql = "INSERT INTO NotasFiscais (idNotasFiscais, OperacaoVenda_idOperacaoVenda) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, nota.getIdNotasFiscais());
            pst.setInt(2, nota.getOperacaoVenda_idOperacaoVenda());
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
    public boolean updateNotas(int id, NotasFiscais nota) {
        connectToDB();
        String sql = "UPDATE NotasFiscais SET idNotasFiscais=?, OperacaoVenda_idOperacaoVenda=? where idNotasFiscais= " + id;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, nota.getIdNotasFiscais());
            pst.setInt(2, nota.getOperacaoVenda_idOperacaoVenda());
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
    public boolean deleteNotas(int id) {
        connectToDB();
        String sql = "DELETE FROM NotasFiscais where idNotasFiscais=?";
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
    public ArrayList<NotasFiscais> selectNotas() {
        ArrayList<NotasFiscais> notasFiscais = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM NotasFiscais";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Notas: ");
            while (rs.next()) {
                NotasFiscais notAux = new NotasFiscais(rs.getInt("idNotasFiscais"),rs.getInt("OperacaoVenda_idOperacaoVenda"));
                System.out.println("idNotaFiscal = " + notAux.getIdNotasFiscais());
                System.out.println("OperaçãoVendaId = " + notAux.getOperacaoVenda_idOperacaoVenda());
                System.out.println("--------------------------------");
                notasFiscais.add(notAux);
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
        return notasFiscais;
    }

}

