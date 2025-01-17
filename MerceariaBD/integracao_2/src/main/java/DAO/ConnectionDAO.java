package DAO;


import java.sql.*;

public abstract class ConnectionDAO {
    Connection con; //conexão
    PreparedStatement pst; // declaração(query) preparada - código em sql
    Statement st; //declaração(query) - código em sql
    ResultSet rs; //resposta do banco
    String database = "mydb";//nome do BD
    String user = "root";
    String password = "suasenha";
    String url = "jdbc:mysql://localhost:3306/" + database;

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao deu certo!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}