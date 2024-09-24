
package egkestoque;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interface extends JFrame {
    private Estoque estoque;
    private DefaultTableModel tableModel;  
    private JTable tabela;  

    public Interface(Estoque estoque, Dbestq db) {
        this.estoque = estoque;
        setTitle("Controle de Estoque");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());  
        mainPanel.setBorder(new EmptyBorder(4, 4, 4, 4));   
        add(mainPanel);

        String[] colunas = {"Patrimônio", "Tipo", "Modelo", "Proprietário"};
        
        tableModel = new DefaultTableModel(colunas, 0);
        tabela = new JTable(tableModel);
        
        // Adicionando o RowSorter para habilitar a ordenação nas colunas
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        tabela.setRowSorter(sorter);
        
        JScrollPane scrollPane = new JScrollPane(tabela);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnSalvar = new JButton("Salvar");  

        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnEditar);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnSalvar);  
        mainPanel.add(panelBotoes, BorderLayout.SOUTH);

        // Carrega os itens existentes do banco de dados ao iniciar o programa
        carregarItens(db);

        // Adicionando o evento para o botão "Adicionar"
        btnAdicionar.addActionListener(e -> {
            JDialog dialog = new JDialog(this, "Adicionar Item", true);  // Cria um JDialog modal
            dialog.setSize(300, 200);
            dialog.setLayout(new GridLayout(5, 2));

            // Demais implementações para adicionar item...
        });

        // Adicionando funcionalidades para editar e excluir itens
        // ...
    }

    // Método para carregar os itens existentes no banco de dados
    private void carregarItens(Dbestq db) {
        try {
            ResultSet rs = db.listarItens();  // Método que retorna os itens do banco de dados
            while (rs.next()) {
                int patrimonio = rs.getInt("patrimonio");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                String proprietario = rs.getString("proprietario");

                // Adiciona os itens à tabela
                tableModel.addRow(new Object[]{patrimonio, tipo, modelo, proprietario});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar itens do banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
