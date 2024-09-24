package egkestoque;

public class Tratamento extends Thread {
    private Estoque estoque;

    public Tratamento(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public void run() {
        try {
            // Simulação de uma operação que pode falhar
            estoque.listar();
        } catch (Exception e) {
            System.out.println("Erro ao listar itens: " + e.getMessage());
        }
    }
}
