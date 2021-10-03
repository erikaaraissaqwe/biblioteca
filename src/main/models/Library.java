package main.models;

import main.utils.DataValidator;
import main.utils.Occupation;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Person> people;
    private final List<Book> books;

    public Library() {
        people = new ArrayList<>();
        books = new ArrayList<>();
    }

    public List<Person> getAllPersons(){
        return people;
    }

    public Person getOnePerson(String cpf){
        if (verifyCpf(cpf)){
            for (Person person: people) {
                if (cpf.equals(person.getCpf())) {
                    return person;
                }
            }
        }
        return null;
    }

    public boolean addPerson(String cpf, String name, String rua, String number, String cep, List<String> emails, List<String> phoneNumber, String birthday, Occupation occupation){
        if (cpf.isEmpty() || !DataValidator.isCpf(cpf) || name.isEmpty() || rua.isEmpty() || !DataValidator.isNumber(number) || number.isEmpty() || cep.isEmpty() || emails.size() == 0 || phoneNumber.size() == 0 || birthday == null || occupation == null){
            return false;
        }
        for (Person person: people) {
            if (cpf.equals(person.getCpf())) {
                return false;
            }
        }
        Person newPerson = new Person(cpf, name, rua, Long.valueOf(number), cep, emails, phoneNumber, DataValidator.formatStringInDate(birthday), occupation);
        people.add(newPerson);
        return true;
    }

    public boolean updatePerson(String cpf, String name, String rua, String number, String cep, List<String> emails, List<String> phoneNumber, String birthday, Occupation occupation){
        if (cpf.isEmpty() || !DataValidator.isCpf(cpf) || name.isEmpty() || rua.isEmpty() || !DataValidator.isNumber(number) || number.isEmpty() || cep.isEmpty() || emails.size() == 0 || phoneNumber.size() == 0 || birthday == null || occupation == null){
            return false;
        }
        if (verifyCpf(cpf)){
            for (Person person: people) {
                if (cpf.equals(person.getCpf())) {
                    Person newPerson = new Person(cpf, name, rua, Long.valueOf(number), cep, emails, phoneNumber, DataValidator.formatStringInDate(birthday), occupation);
                    Person oldPerson = getOnePerson(cpf);
                    int index = people.indexOf(oldPerson);
                    people.remove(oldPerson);
                    people.add(index, newPerson);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deletePerson(String cpf){
        if (verifyCpf(cpf)){
            for (Person person: people) {
                if (cpf.equals(person.getCpf())) {
                    Person oldPerson = getOnePerson(cpf);
                    people.remove(oldPerson);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyCpf(String cpf){
        for (Person person: people) {
            if (person.getCpf().equals(cpf)) {
                return true;
            }
        }
        return  false;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getOneBook(String isbn){
        if (verifyIsbn(isbn)){
            for (Book book: books) {
                if (isbn.equals(book.getIsbn())) {
                    return book;
                }
            }
        }
        return null;
    }

    public boolean addBook(String isbn, String title, String genre, List<String> authors, String numberOfPages){
        if (isbn.isEmpty() || title.isEmpty() || genre.isEmpty() || !DataValidator.isNumber(numberOfPages) || numberOfPages.isEmpty() || authors.size() == 0){
            return false;
        }
        for (Book book: books) {
            if (isbn.equals(book.getIsbn())) {
                return false;
            }
        }
        Book newBook = new Book(isbn, title, genre, authors, Long.valueOf(numberOfPages));
        books.add(newBook);
        return true;
    }

    public boolean updateBook(String isbn, String title, String genre, List<String> authors, String numberOfPages){
        System.out.println(authors.size());
        if (isbn.isEmpty() || title.isEmpty() || genre.isEmpty() || !DataValidator.isNumber(numberOfPages) || authors.size() == 0){
            return false;
        }
        if (verifyIsbn(isbn)){
            for (Book book: books) {
                if (isbn.equals(book.getIsbn())) {
                    Book newBook = new Book(isbn, title, genre, authors, Long.valueOf(numberOfPages));
                    Book oldBook = getOneBook(isbn);
                    int index = books.indexOf(oldBook);
                    books.remove(oldBook);
                    books.add(index, newBook);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteBook(String isbn){
        if (verifyIsbn(isbn)){
            for (Book book: books) {
                if (isbn.equals(book.getIsbn())) {
                    Book oldBook = getOneBook(isbn);
                    books.remove(oldBook);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyIsbn(String isbn){
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return  false;
    }
}
