package main.models;

import main.utils.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Person> persons;
    private List<Book> books;

    public Library() {
        persons = new ArrayList<Person>();
        books = new ArrayList<Book>();
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getOne(String isbn){
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
                    Book oldBook = getOne(isbn);
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
                    Book oldBook = getOne(isbn);
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
