package DAO;
import Model.Clientes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertClientes(Clientes cliente) {
        connectToDB();
        String sql = "INSERT INTO Cliente (CPF, Nome, Telefone) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getCPF());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getTelefone());
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
    public boolean updateClientes(int id, Clientes cliente) {
        connectToDB();
        String sql = "UPDATE Cliente SET CPF=?, Nome=?, Telefone=? where CPF=" + id;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getCPF());
            pst.setString(2, cliente.getNome());
            pst.setString(3,cliente.getTelefone());
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
    public boolean deleteClientes(int id) {
        connectToDB();
        String sql = "DELETE FROM Cliente where id=?";
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
    public ArrayList<Clientes> selectCliente() {
        ArrayList<Clientes> clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Cliente: ");
            while (rs.next()) {
                Clientes clienteAux = new Clientes(rs.getInt("CPF"),rs.getString("Nome"), rs.getString("Telefone"));
                System.out.println("cpf = " + clienteAux.getCPF());
                System.out.println("nome = " + clienteAux.getNome());
                System.out.println("telefone = " + clienteAux.getTelefone());
                System.out.println("--------------------------------");
                clientes.add(clienteAux);
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
        return clientes;
    }

}
