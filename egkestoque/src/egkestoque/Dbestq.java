package egkestoque;

import java.sql.*;

public class Dbestq {
    private Connection connection;

    public Dbestq() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/engekoestoque_db";
        String user = "root";
        String password = "Asdasas32";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void adicionarItem(Item item) throws SQLException {
        String sql = "INSERT INTO itens_estoque (patrimonio, tipo, modelo, proprietario) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, item.getPatrimonio());
        statement.setString(2, item.getTipo());
        statement.setString(3, item.getModelo());
        statement.setString(4, item.getProprietario());
        statement.executeUpdate();
    }

    public void editarItem(Item item) throws SQLException {
        String sql = "UPDATE itens_estoque SET tipo=?, modelo=?, proprietario=? WHERE patrimonio=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, item.getTipo());
        statement.setString(2, item.getModelo());
        statement.setString(3, item.getProprietario());
        statement.setInt(4, item.getPatrimonio());
        statement.executeUpdate();
    }

    public void excluirItem(int patrimonio) throws SQLException {
        String sql = "DELETE FROM itens_estoque WHERE patrimonio=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, patrimonio);
        statement.executeUpdate();
    }

    public ResultSet listarItens() throws SQLException {
        String sql = "SELECT * FROM itens_estoque";
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
}
