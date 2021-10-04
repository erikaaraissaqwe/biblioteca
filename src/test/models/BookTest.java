package models;

import main.models.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {
    private Book principal;
    ArrayList<String> authors;

    @BeforeAll
    public void createBook(){
        authors = new ArrayList<>(List.of("Erika, Raissa, Bueno"));
        principal = new Book("123456l", "Como fazer um teste?", "Acadêmico", authors, 856L);
    }

    @Test
    @DisplayName("Teste - MAC")
    @EnabledOnOs({OS.MAC})
    @Order(15)
    void setTitleParaMacTest(){
        Book b = new Book();
        b.setTitle("Como fazer um teste em JUnit?");
        String expected = "Como fazer um teste em JUnit?";
        assertEquals(expected, b.getTitle());
    }

    @Test
    @DisplayName("Teste - Windows")
    @EnabledOnOs({OS.WINDOWS})
    @Order(16)
    void setTitleWindowsTest(){
        Book b = new Book();
        b.setTitle("Como fazer um teste em JUnit II?");
        String expected = "Como fazer um teste em JUnit II?";
        assertEquals(expected, b.getTitle());
    }

    @Test
    @DisplayName("Teste - Java 8")
    @EnabledOnJre(JRE.JAVA_8)
    @Order(17)
    void setISBNParaJRE8Test(){
        Book b = new Book();
        b.setIsbn("9876h");
        String expected = "9876h";
        assertEquals(expected, b.getIsbn());
    }

    @DisplayName("Teste - Java 11")
    @EnabledOnJre(JRE.JAVA_11)
    @ParameterizedTest
    @ValueSource(strings = {"658L", "965L", "95645L"})
    @Order(18)
    void setISBNParaTest(String str){
        Book b = new Book();
        b.setIsbn(str);
        assertEquals(str, b.getIsbn());
    }

    @DisplayName("Teste parametrizado para getTitle")
    @ParameterizedTest
    @ValueSource(strings = {"Livro I", "Livro II", "Livro III"})
    @Order(19)
    void getTitleParametrizadoTest(String str){
        Book b = new Book();
        b.setTitle(str);
        assertEquals(str, b.getTitle());
    }

    @DisplayName("Teste parametrizado para setGenre")
    @ParameterizedTest
    @ValueSource(strings = {"Romance", "Aventura", "Distopia"})
    @Order(20)
    void setGenreParametrizadoTest(String str){
        Book b = new Book();
        b.setGenre(str);
        assertEquals(str, b.getGenre());
    }

    @Test
    @DisplayName("Testa se o título e o gênero são iguais")
    @Order(1)
    public void getsTest(){
        assertAll(
                () -> assertNotNull(principal),
                () -> assertEquals("Como fazer um teste?", principal.getTitle()),
                () -> assertEquals("Acadêmico",principal.getGenre())
        );
    }

    @Test
    @DisplayName("Testa getISBN do book principal")
    @Order(2)
    public void getISBNTest() {
        Assertions.assertEquals("123456l", principal.getIsbn());
    }

    @Test
    @DisplayName("Testa setISBN do book principal")
    @Order(3)
    public void setISBNTest() {
        principal.setIsbn("123456OP");
        Assertions.assertEquals("123456OP", principal.getIsbn());
    }

    @Test
    @DisplayName("Testa getTitle do book principal")
    @Order(4)
    public void getNameTest() {
        Assertions.assertEquals("Como fazer um teste?", principal.getTitle());
    }

    @Test
    @DisplayName("Testa setTitle do book principal")
    @Order(5)
    public void setTitleTest() {
        principal.setTitle("Erika Raissa Bueno da Silva");
        Assertions.assertEquals("Erika Raissa Bueno da Silva", principal.getTitle());
    }

    @Test
    @DisplayName("Testa getGenre do book principal")
    @Order(6)
    public void getGenreTest() {
        Assertions.assertEquals("Acadêmico", principal.getGenre());
    }

    @Test
    @DisplayName("Testa setGenre do book principal")
    @Order(7)
    public void setGenreTest() {
        principal.setGenre("Romance");
        Assertions.assertEquals("Romance", principal.getGenre());
    }

    @Test
    @DisplayName("Testa getNumberOfPages do book principal")
    @Order(8)
    public void getNumberOfPagesTest() {
        Assertions.assertEquals(856L, principal.getNumberOfPages());
    }

    @Test
    @DisplayName("Testa setNumberOfPagesOfPagesOfPages do book principal")
    @Order(9)
    public void setNumberOfPagesOfPagesOfPagesTest() {
        principal.setNumberOfPages(859L);
        Assertions.assertEquals(859L, principal.getNumberOfPages());
    }

    @Test
    @DisplayName("Testa getAuthors do book principal")
    @Order(10)
    public void getAuthorsTest() {
        Assertions.assertEquals(authors, principal.getAuthors());
    }

    @Test
    @DisplayName("Testa setAuthors do book principal")
    @Order(11)
    public void setAuthorsTest() {
        ArrayList<String> authors2 = new ArrayList<>(Arrays.asList("Izabel", "Victor", "Raissa"));
        principal.setAuthors(authors2);
        Assertions.assertArrayEquals(new ArrayList[]{authors2}, new ArrayList[]{(ArrayList) principal.getAuthors()});
    }

    @Test
    @DisplayName("Testa a criação de um novo book")
    @Order(12)
    public void createNewPersonTest() {
        Book p = new Book("POT78", "Jogos Vorazes", "Distopia", authors, 756L);
        assertAll(
                () -> assertNotNull(p),
                () -> assertEquals("Jogos Vorazes", p.getTitle()),
                () -> assertEquals("POT78",p.getIsbn()),
                () -> assertEquals("Distopia", p.getGenre()),
                () -> assertEquals(756L, p.getNumberOfPages())
        );
    }

    @Test
    @DisplayName("Testa o equals do book")
    @Order(13)
    public void equalsPersonTest() {
        Book b = new Book("123456OP", "Como fazer um teste II?", "Acadêmico II", authors, 856L);
        assertTrue(b.equals(principal));
    }

    @Test
    @DisplayName("Testa o toString do book")
    @Order(14)
    public void toStringPersonTest() {
        Book p = new Book("POT78", "Jogos Vorazes", "Distopia", authors, 756L);
        String bookForToString = "\n\nLivro " + p.getIsbn() +":\n" +
                "Isbn=" +  p.getIsbn() + '\n' +
                "Titulo=" +  p.getTitle() + '\n' +
                "Genero=" +  p.getGenre() + '\n' +
                "Autores=" + p.getAuthors() + '\n' +
                "Páginas=" + p.getNumberOfPages() +
                "\n";
        assertEquals(bookForToString, p.toString());
    }
}
