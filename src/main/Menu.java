package main;

import main.models.Library;
import main.models.Book;
import main.models.Person;
import main.utils.Occupation;

import java.util.List;
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
            System.out.print("->");
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
            System.out.print("->");
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
                    System.out.print("ISBN: ");
                    String isbn = l.nextLine();
                    Book b = library.getOneBook(isbn);
                    if (b == null){
                        System.out.println("\nEste livro não está cadastrado\n");
                    } else{
                        System.out.println(b);
                    }

                    break;
                case 3:
                    System.out.print("ISBN: ");
                    isbn = l.nextLine();
                    System.out.print("TÍTULO: ");
                    String title = l.nextLine();
                    System.out.print("GÊNERO: ");
                    String genre = l.nextLine();
                    System.out.print("AUTORES: ");
                    String autor = l.nextLine();
                    System.out.print("PÁGINAS: ");
                    String page = l.nextLine();

                    if (library.addBook(isbn, title, genre, List.of(autor.split(",")), page)){
                        System.out.println("\nCadastrado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível cadastrar.\n");
                    }
                    break;
                case 4:
                    System.out.print("ISBN: ");
                    isbn = l.nextLine();
                    System.out.print("TÍTULO: ");
                    title = l.nextLine();
                    System.out.print("GÊNERO: ");
                    genre = l.nextLine();
                    System.out.print("AUTORES: ");
                    autor = l.nextLine();
                    System.out.print("PÁGINAS: ");
                    page = l.nextLine();

                    if (library.updateBook(isbn, title, genre, List.of(autor.split(",")), page)){
                        System.out.println("\nAtualizado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível atualizar.\n");
                    }
                    break;
                case 5:
                    System.out.print("ISBN: ");
                    isbn = l.nextLine();
                    Book book = library.getOneBook(isbn);
                    if(book == null){
                        System.out.println("\nNão existe esse livro cadastrado\n");
                    } else{
                        System.out.print("\n\nDeseja excluir esse livro?  \n" + book + "\nS para SIM \nN para NÃO\n");
                        String verify = l.nextLine();
                        if(verify.equalsIgnoreCase("S")){
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
            System.out.print("->");
            option = l.nextInt();
            l.nextLine();
            System.out.println();

            switch (option){
                case 1:
                    List<Person> listPeople = library.getAllPersons();
                    for (Person p : listPeople){
                        System.out.println(p.toString());
                    }
                    break;
                case 2:
                    System.out.print("CPF: ");
                    String cpf = l.nextLine();
                    Person p = library.getOnePerson(cpf);
                    if (p == null){
                        System.out.println("\nEsta pessoa não está cadastrada\n");
                    } else{
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("CPF: ");
                    cpf = l.nextLine();
                    System.out.print("NOME: ");
                    String name = l.nextLine();
                    System.out.print("RUA: ");
                    String rua = l.nextLine();
                    System.out.print("NUMBER: ");
                    String number = l.nextLine();
                    System.out.print("CEP: ");
                    String cep = l.nextLine();
                    System.out.print("EMAILS: ");
                    String emails = l.nextLine();
                    System.out.print("TELEFONES: ");
                    String phoneNumber = l.nextLine();
                    System.out.print("DATA DE NASCIMENTO: ");
                    String birthdayString = l.nextLine();
                    System.out.print("PROFISSÃO:\n{1 - ESTUDANTE}\n{2 - PROFESSOR}\n");
                    int occupationType = l.nextInt();
                    Occupation occupation;
                    if(occupationType == 1){
                        occupation = Occupation.ALUNO;
                    } else{
                        occupation = Occupation.PROFESSOR;
                    }
                    if (library.addPerson(cpf, name, rua, number, cep, List.of(emails.split(",")), List.of(phoneNumber.split(",")),birthdayString, occupation)){
                        System.out.println("\nCadastrado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível cadastrar.\n");
                    }
                    break;
                case 4:
                    System.out.print("CPF: ");
                    cpf = l.nextLine();
                    System.out.print("NOME: ");
                     name = l.nextLine();
                    System.out.print("RUA: ");
                     rua = l.nextLine();
                    System.out.print("NUMBER: ");
                    number = l.nextLine();
                    System.out.print("CEP: ");
                    cep = l.nextLine();
                    System.out.print("EMAILS: ");
                    emails = l.nextLine();
                    System.out.print("TELEFONES: ");
                    phoneNumber = l.nextLine();
                    System.out.print("DATA DE NASCIMENTO: ");
                    birthdayString = l.nextLine();
                    System.out.print("PROFISSÃO:\n[1] - ESTUDANTE\n[2] - PROFESSOR\n");
                    occupationType = l.nextInt();
                    if(occupationType == 1){
                        occupation = Occupation.ALUNO;
                    } else{
                        occupation = Occupation.PROFESSOR;
                    }
                    if (library.updatePerson(cpf, name, rua, number, cep, List.of(emails.split(",")), List.of(phoneNumber.split(",")),birthdayString, occupation)){
                        System.out.println("\nAtualizado com sucesso.\n");
                    }else{
                        System.out.println("\nNão foi possível atualizar.\n");
                    }

                    break;
                case 5:
                    System.out.print("CPF: ");
                    cpf = l.nextLine();
                    Person person = library.getOnePerson(cpf);
                    if(person == null){
                        System.out.println("\nNão existe essa pessoa cadastrada\n");
                    } else{
                        System.out.print("\n\nDeseja excluir essa pessoa?  \n" + person + "\nS para SIM \nN para NÃO\n");
                        String verify = l.nextLine();
                        if(verify.equalsIgnoreCase("S")){
                            if (library.deletePerson(person.getCpf())){
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
}
