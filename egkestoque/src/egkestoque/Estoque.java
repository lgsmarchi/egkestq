package egkestoque;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Operacoes {
    private List<Item> itens;
    private Dbestq db;  // Conexão com o banco de dados

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void setDb(Dbestq db) {
        this.db = db;
    }

    @Override
    public void adicionar(Item item) {
        itens.add(item);
        try {
            db.adicionarItem(item);
            System.out.println("Item adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar item no banco de dados: " + e.getMessage());
        }
    }

    @Override
    public void editar(Item item) {
        for (Item i : itens) {
            if (i.getPatrimonio() == item.getPatrimonio()) {
                i.setTipo(item.getTipo());
                i.setModelo(item.getModelo());
                i.setProprietario(item.getProprietario());
                try {
                    db.editarItem(item);
                    System.out.println("Item editado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Erro ao editar item no banco de dados: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Item não encontrado!");
    }

    @Override
    public void excluir(int patrimonio) {
        itens.removeIf(i -> i.getPatrimonio() == patrimonio);
        try {
            db.excluirItem(patrimonio);
            System.out.println("Item excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir item no banco de dados: " + e.getMessage());
        }
    }

    @Override
    public void listar() {
        try {
            ResultSet rs = db.listarItens();
            while (rs.next()) {
                int patrimonio = rs.getInt("patrimonio");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                String proprietario = rs.getString("proprietario");
                System.out.println(patrimonio + " | " + tipo + " | " + modelo + " | " + proprietario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens: " + e.getMessage());
        }
    }
}
