package egkestoque;

public class Item {
    private int patrimonio;
    private String tipo;
    private String modelo;
    private String proprietario;

    public Item(int patrimonio, String tipo, String modelo, String proprietario) {
        this.patrimonio = patrimonio;
        this.tipo = tipo;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    // Getters e Setters
    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
}
