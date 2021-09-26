package main.models;

import java.util.List;

public class Book {
    private String isbn;

    private String title;

    private String genre;

    private List<String> authors;

    private Long numberOfPages;

    public Book() {
    }

    public Book(String isbn, String title, String genre, List<String> authors, Long numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public String toString() {
        return "\n\nLivro " + isbn +":\n" +
                "Isbn=" + isbn + '\n' +
                "Titulo=" + title + '\n' +
                "Genero=" + genre + '\n' +
                "Autores=" + authors + '\n' +
                "Páginas=" + numberOfPages +
                "\n";
    }
}
