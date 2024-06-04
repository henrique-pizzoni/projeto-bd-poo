package DAO;
import Model.Vendedores;

import java.sql.SQLException;
import java.util.ArrayList;

public class VendedoresDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertVendedor(Vendedores vendedor) {
        connectToDB();
        String sql = "INSERT INTO Vendedores (idVendedores, Nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, vendedor.getId());
            pst.setString(2, vendedor.getNome());
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
    public boolean updateVendedores(int id, Vendedores vendedor) {
        connectToDB();
        String sql = "UPDATE Vendedores SET idVendedores=?, Nome=? where idVendedores= " + id;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, vendedor.getId());
            pst.setString(2, vendedor.getNome());
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
    public boolean deleteVendedores(int id) {
        connectToDB();
        String sql = "DELETE FROM Vendedores where idVendedores=?";
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
    public ArrayList<Vendedores> selectVendedor() {
        ArrayList<Vendedores> vendedores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Vendedores";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Vendedores: ");
            while (rs.next()) {
                Vendedores vendAux = new Vendedores(rs.getInt("idVendedores"),rs.getString("Nome"));
                System.out.println("idVendedor = " + vendAux.getId());
                System.out.println("Nome = " + vendAux.getNome());
                System.out.println("--------------------------------");
                vendedores.add(vendAux);
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
        return vendedores;
    }

}
