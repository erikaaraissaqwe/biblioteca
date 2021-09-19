package main;

import main.models.Library;
import main.models.Book;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    Library library = new Library();
    public void mainMenu() {

        int opt;

        Scanner leitor = new Scanner(System.in);

        do{
            System.out.println("=============BIBLIOTECA=============");
            System.out.println("Submenu de Pessoas .............. [1]");
            System.out.println("Submenu de Livros ............... [2]");
            System.out.println("Sair ............................ [0]");
            System.out.printf("->");
            opt = leitor.nextInt();
            leitor.nextLine();
            System.out.println();

            switch (opt){
                case 1:
                    peopleMenu();
                    break;
                case 2:
                    bookMenu();

            }
        } while (opt != 0);

    }

    public void bookMenu(){
        int option;

        Scanner l = new Scanner(System.in);

        do{
            System.out.println("===============LIVROS===============");
            System.out.println("Listar todos os livros ......... [1]");
            System.out.println("Listar um livros ............... [2]");
            System.out.println("Adicionar Livro ................ [3]");
            System.out.println("Editar Livro ................... [4]");
            System.out.println("Remover Livro .................. [5]");
            System.out.println("Sair ........................... [0]");
            System.out.printf("->");
            option = l.nextInt();
            l.nextLine();
            System.out.println();

            switch (option){
                case 1:
                    List<Book> listBook = library.getAllBooks();
                    for (Book b : listBook){
                        System.out.println(b.toString());
                    }
                    break;
                case 2:
                    System.out.printf("ISBN: ");
                    String isbn = l.nextLine();
                    Book b = library.getOne(isbn);
                    if (b == null){
                        System.out.println("\nEste livro não está cadastrado\n");
                    } else{
                        System.out.println(b.toString());
                    }

                    break;
                case 3:
                    System.out.printf("ISBN: ");
                    isbn = l.nextLine();
                    System.out.printf("TÍTULO: ");
                    String title = l.nextLine();
                    System.out.printf("GÊNERO: ");
                    String genre = l.nextLine();
                    System.out.printf("AUTORES: ");
                    String autor = l.nextLine();
                    System.out.printf("PÁGINAS: ");
                    String page = l.nextLine();

                    if (library.addBook(isbn, title, genre, List.of(autor.split(",")), page)){
                        System.out.println("\nCadastrado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível cadastrar.\n");
                    }
                    break;
                case 4:
                    System.out.printf("ISBN: ");
                    isbn = l.nextLine();
                    System.out.printf("TÍTULO: ");
                    title = l.nextLine();
                    System.out.printf("GÊNERO: ");
                    genre = l.nextLine();
                    System.out.printf("AUTORES: ");
                    autor = l.nextLine();
                    System.out.printf("PÁGINAS: ");
                    page = l.nextLine();

                    if (library.updateBook(isbn, title, genre, List.of(autor.split(",")), page)){
                        System.out.println("\nAtualizado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível atualizar.\n");
                    }
                    break;
                case 5:
                    System.out.printf("ISBN: ");
                    isbn = l.nextLine();
                    Book book = library.getOne(isbn);
                    if(book == null){
                        System.out.println("\nNão existe esse livro cadastrado\n");
                    } else{
                        System.out.printf("\n\nDeseja excluir esse livro?  \n" + book.toString() + "\nS para SIM \nN para NÃO\n");
                        String verify = l.nextLine();
                        if(verify.toUpperCase().equals("S")){
                            if (library.deleteBook(book.getIsbn())){
                                System.out.println("\nRemovido com sucesso\n");
                            }else{
                                System.out.println("\nNão foi possível remover\n");
                            }
                        }
                    }

                    break;
            }
        } while (option != 0);
    }

    public void peopleMenu(){
        int option;

        Scanner l = new Scanner(System.in);

        do{
            System.out.println("===============PESSOAS===============");
            System.out.println("Listar todas as pessoas ......... [1]");
            System.out.println("Listar uma pessoa ............... [2]");
            System.out.println("Adicionar pessoa ................ [3]");
            System.out.println("Editar pessoa ................... [4]");
            System.out.println("Remover pessoa .................. [5]");
            System.out.println("Sair ............................ [0]");
            System.out.printf("->");
            option = l.nextInt();
            l.nextLine();
            System.out.println();

            switch (option){
                case 1:

                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } while (option != 0);
    }
}
