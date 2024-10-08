public abstract class ItemBibliografico {
    public String codigo;
    public String titulo;
    public int anoPublicacao;

    public ItemBibliografico(String codigo, String titulo, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean validarCamposItem(){
        if (this.getCodigo().isEmpty()) {
            throw new RuntimeException("Código inválido");
        } else if (this.getTitulo().isEmpty()) {
            throw new RuntimeException("Título vazio, preencha todos os campos");
        } else if (this.getAnoPublicacao() < 1000 && this.getAnoPublicacao() > 2024) {
            throw new RuntimeException("Ano inválido!");
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder model = new StringBuilder();
        model.append("Código " + codigo + " - Título: "+titulo);
        model.append("\n Ano de publicação: "+anoPublicacao);
        return model.toString();
    }
}
