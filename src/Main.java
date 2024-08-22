import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n Itens da biblioteca");

        Livro livro = new Livro("","",600,"fulano","blablablabla",
                new ItemBibliografico("","", 600));
        System.out.println(livro);

        Periodico periodico = new Periodico("","",600,"fulano",0,
                new ItemBibliografico("","", 600));
        System.out.println(periodico);
    }
}