import java.util.*;

public class Biblioteca {
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
                buscarPorCodigo();
            } else if (opcao == 3) {
                listarItens();
            } else if (opcao == 0) {
                execute = false;
            }
        }
    }

    public void adicionarItem(){
        ItemBibliografico item = null;
        Periodico periodico = null;
        Livro livro = null;
        int opcao = scanner("Digite 1 para adicionar periódico e 2 para adicionar um livro").nextInt();
        if (opcao == 1) {
            String codigo = scanner("Digite o código: ").next();
            String titulo = scanner("Digite o título: ").next();
            int anoPublicacao = scanner("Digite o ano de publicação: ").nextInt();
            String periodicidade = scanner("Digite a periodicidade: ").next();
            int volume = scanner("Digite o volume: ").nextInt();

            periodico = new Periodico(codigo, titulo, anoPublicacao, periodicidade, volume);

            try {
                if (periodico.validarCampos()) {
                    itens.add(periodico);
                    System.out.println("Item adicionado com sucesso!");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        } else if (opcao == 2) {
            String codigo = scanner("Digite o código: ").next();
            String titulo = scanner("Digite o título: ").next();
            int anoPublicacao = scanner("Digite o ano de publicação: ").nextInt();
            String autor = scanner("Digite o autor: ").next();
            String isbn = scanner("Digite o isbn: ").next();

            livro = new Livro(codigo,titulo,anoPublicacao,autor,isbn);

            try {
                if (livro.validarCampos()) {
                    itens.add(livro);
                    System.out.println("Item adicionado com sucesso!");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ItemBibliografico buscarPorCodigo(){
        String codigoProcurado = scanner("Digite o código que deseja buscar").next();
        for (ItemBibliografico item : this.itens) {
            if (item.codigo.equals(codigoProcurado)) {
                System.out.println(item);
            }
        }
        return null;
    }

    public void listarItens(){
        for (int i=0; i< itens.size(); i++) {
            System.out.printf("\n" + itens.get(i) + "\n");
        }
    }

    @Override
    public String toString() {
        return "Itens da biblioteca: " + itens;
    }

    public static Scanner scanner (String message){
        System.out.println(message);
        return new Scanner(System.in);
    }
}
