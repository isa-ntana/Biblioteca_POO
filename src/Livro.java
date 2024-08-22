public class Livro extends ItemBibliografico{
    String autor;
    String isbn;
    ItemBibliografico itemBibliografico;

    public Livro(String codigo, String titulo, int anoPublicacao, String autor, String isbn, ItemBibliografico itemBibliografico) {
        super(codigo, titulo, anoPublicacao);
        this.autor = autor;
        this.isbn = isbn;
        this.itemBibliografico = itemBibliografico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean validarCampos(){
        if (this.getIsbn().length() < 10 || this.getIsbn().length() > 13){
            throw new RuntimeException("ISBN inválido, preencha corretamente");
        } else if (this.getAutor().isEmpty()) {
            throw new RuntimeException("O nome do autor está vazio, preencha!");
        }
        return true;
    }

    @Override
    public String toString() {
        validarCampos();
        StringBuilder model = new StringBuilder();
        model.append(super.toString());
        model.append("\n Autor: "+autor);
        model.append("\n ISBN: "+isbn);
        return model.toString();
    }
}
