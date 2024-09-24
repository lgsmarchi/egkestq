package egkestoque;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Inicializa a conexão com o banco de dados
        Estoque estoque = new Estoque();

        try {
            Dbestq db = new Dbestq();  // Conecta ao banco de dados
            estoque.setDb(db);  // Configura o objeto db no estoque

            // Inicializa a interface gráfica na Event Dispatch Thread (EDT)
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Interface gui = new Interface(estoque, db);  // Passa Estoque e banco de dados
                    gui.setVisible(true);
                }
            });

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
