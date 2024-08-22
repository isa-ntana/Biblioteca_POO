import java.util.*;

public abstract class Biblioteca {
    public List<ItemBibliografico> itens;

    public Biblioteca(List<ItemBibliografico> itens) {
        this.itens = itens;
    }

    public Biblioteca() {
        this.itens = new ArrayList<>();
    }

    public void menu() {
        boolean execute = true;
        while (execute) {
            int opcao = scanner("Digite a opção desejada:" +
                    "\n 1 - Adicionar item a biblioteca" +
                    "\n 2 - Buscar item por código" +
                    "\n 3 - Listar itens da biblioteca" +
                    "\n 0 - Sair").nextInt();
            if (opcao == 1) {
                adicionarItem();
            } else if (opcao == 2) {
                //buscarPorCodigo();
            } else if (opcao == 3) {
                System.out.println(itens);
            } else if (opcao == 0) {
                execute = false;
            }
        }
    }

    public void adicionarItem(){
        ItemBibliografico item = null;
        int opcao = scanner("Digite 1 para adicionar periódico e 2 para adicionar um livro").nextInt();
        if (opcao == 1) {
            item = new Periodico(adicionarPeriodico().codigo, adicionarPeriodico().titulo, adicionarPeriodico().anoPublicacao, adicionarPeriodico().periodicidade, adicionarPeriodico().volume,new ItemBibliografico(adicionarPeriodico().codigo, adicionarPeriodico().titulo, adicionarPeriodico().anoPublicacao));
        } else if (opcao == 2) {
            item = new Livro(adicionarLivro().codigo, adicionarLivro().titulo, adicionarLivro().anoPublicacao,adicionarLivro().autor, adicionarLivro().isbn,new ItemBibliografico(adicionarPeriodico().codigo, adicionarPeriodico().titulo, adicionarPeriodico().anoPublicacao));
        }
        itens.add(item);
    }

    public Periodico adicionarPeriodico(){
        String codigo = scanner("Digite o código: ").next();
        String titulo = scanner("Digite o título: ").next();
        int anoPublicacao = scanner("Digite o ano de publicação: ").nextInt();
        String periodicidade = scanner("Digite a periodicidade: ").next();
        int volume = scanner("Digite o volume: ").nextInt();

        return new Periodico(codigo, titulo, anoPublicacao, periodicidade,volume, new ItemBibliografico(codigo,titulo,anoPublicacao));
    }

    public Livro adicionarLivro(){
        String codigo = scanner("Digite o código: ").next();
        String titulo = scanner("Digite o título: ").next();
        int anoPublicacao = scanner("Digite o ano de publicação: ").nextInt();
        String autor = scanner("Digite o autor: ").next();
        String isbn = scanner("Digite o isbn: ").next();

        return new Livro(codigo,titulo,anoPublicacao,autor,isbn,new ItemBibliografico(codigo,titulo,anoPublicacao));
    }

    public ItemBibliografico buscarPorCodigo(String codigo){
        for (ItemBibliografico item : this.itens) { if (item.codigo.equals(codigo)) return item; }
        return null;
    }

    /*public ItemBibliografico listarItens(ItemBibliografico item){
        int index = this.itens.indexOf(item);
        return this.itens.get(index);
    } */

    @Override
    public String toString() {
        return "Itens da biblioteca: " + itens;
    }

    public static Scanner scanner (String message){
        System.out.println(message);
        return new Scanner(System.in);
    }
}
