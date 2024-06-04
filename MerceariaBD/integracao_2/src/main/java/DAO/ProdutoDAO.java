package DAO;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;


    public class ProdutoDAO extends ConnectionDAO{
        //DAO - Data Access Object
        boolean sucesso = false; //Para saber se funcionou
        //INSERT
        public boolean insertProduto(Produtos produto) {
            connectToDB();
            String sql = "INSERT INTO Produtos (idProdutos, Valor, Nome) values(?,?, ?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, produto.getIdProdutos());
                pst.setInt(2, produto.getValor());
                pst.setString(3, produto.getNome());
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
        public boolean UpdateProdutos(int id, Produtos produto) {
            connectToDB();
            String sql = "UPDATE Produtos SET idProdutos=?, Valor=?, Nome=?, where idProdutos= " + id;
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, produto.getIdProdutos());
                pst.setInt(2, produto.getValor());
                pst.setString(3, produto.getNome());
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
        public boolean deleteProdutos(int id) {
            connectToDB();
            String sql = "DELETE FROM Produtos where idProdutos=?";
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
        public ArrayList<Produtos> selectProduto() {
            ArrayList<Produtos> produtos = new ArrayList<>();
            connectToDB();
            String sql = "SELECT * FROM Produtos";
            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                System.out.println("Lista de Notas: ");
                while (rs.next()) {
                    Produtos prodAUX = new Produtos(rs.getInt("idProdutos"),rs.getInt("Valor"), rs.getString("Nome"));
                    System.out.println("idProduto = " + prodAUX.getIdProdutos());
                    System.out.println("Valor = " + prodAUX.getValor());
                    System.out.println("Nome = " + prodAUX.getNome());
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





