public class Periodico extends ItemBibliografico {
    String periodicidade;
    int volume;
    ItemBibliografico itemBibliografico;

    public Periodico(String codigo, String titulo, int anoPublicacao, String periodicidade, int volume, ItemBibliografico itemBibliografico) {
        super(codigo, titulo, anoPublicacao);
        this.itemBibliografico = itemBibliografico;
        this.volume = volume;
        this.periodicidade = periodicidade;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean validarCampos(){
        if (this.getPeriodicidade().isEmpty()){
            throw new RuntimeException("Periodicidade está vazia, preencha!");
        } else if (this.getVolume() < 0 && this.getPeriodicidade().isEmpty()) {
            throw new RuntimeException("Volume inválido!");
        }
        return true;
    }

    public String toString() {
        StringBuilder model = new StringBuilder();
        model.append(super.toString());
        model.append("\n Periodicidade: "+periodicidade);
        model.append("\n Volume: "+volume);
        return model.toString();
    }
}
