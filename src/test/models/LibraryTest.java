package models;

import main.models.Book;
import main.models.Library;
import main.models.Person;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static main.utils.Occupation.ALUNO;
import static main.utils.Occupation.PROFESSOR;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {

    private Library library;
    private ArrayList<String> emails;
    private ArrayList<String> phones;
    private ArrayList<String> authors;

    @BeforeAll
    public void create() {
        library = new Library();
        emails = new ArrayList<>(List.of("erikaaraissaqwe@gmail.com"));
        phones = new ArrayList<>(List.of("16 99254-9652"));
        authors = new ArrayList<>(List.of("Sarah S. Mass"));
    }

    @Test
    @Order(1)
    public void addPersonTest(){
        boolean addVerify = library.addPerson("09548936461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(addVerify),
                () -> assertEquals(1, library.getAllPersons().size()),
                () -> assertEquals("Erika Raissa Bueno",library.getOnePerson("09548936461").getName())
        );
    }

    @Test
    @Order(2)
    public void addPersonCPFInvalidTest(){
        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(3)
    public void addPersonCPFEmptyTest(){
        boolean addVerify = library.addPerson("", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(4)
    public void addPersonNameEmptyTest(){
        boolean addVerify = library.addPerson("095489461", "", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(5)
    public void addPersonRuaEmptyTest(){
        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(6)
    public void addPersonNumberEmptyTest(){
        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(7)
    public void addPersonNumberInvalidTest(){
        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "965oa", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(8)
    public void addPersonCEPEmptyTest(){

        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(9)
    public void addPersonEmailEmptyTest(){

        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", new ArrayList<>(), phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(10)
    public void addPersonPhoneEmptyTest(){

        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails , new ArrayList<> (), "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(11)
    public void addPersonBirthdayEmptyTest(){

        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails , phones, null, ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(12)
    public void addPersonOccupationEmptyTest(){

        boolean addVerify = library.addPerson("095489461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails , phones, "17/07/2000", null);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(13)
    public void addPersonRepeatedTest(){
        boolean addVerify = library.addPerson("09548936461", "Erika Raissa Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", ALUNO);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(14)
    public void addSecondyPersonTest(){
        boolean addVerify = library.addPerson("37189370005", "Izabel Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", PROFESSOR);
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(addVerify),
                () -> assertEquals(2, library.getAllPersons().size()),
                () -> assertEquals("Izabel Bueno", library.getOnePerson("37189370005").getName())
        );
    }

    @Test
    @Order(15)
    public void updatePersonTest(){
        boolean updateVerify = library.updatePerson("09548936461", "Izabel Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", PROFESSOR);
        assertAll(
            () -> assertNotNull(library),
                    () -> assertTrue(updateVerify),
                    () -> assertEquals("Izabel Bueno",library.getOnePerson("09548936461").getName()),
                    () -> assertEquals(PROFESSOR,library.getOnePerson("09548936461").getOccupation())
        );
    }

    @Test
    @Order(16)
    public void updatePersonNotExistsTest(){
        boolean updateVerify = library.updatePerson("28761196096", "Izabel Bueno", "Rua das Alamedas", "85", "14815-000", emails, phones, "17/07/2000", PROFESSOR);
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(updateVerify)
        );
    }

    @Test
    @Order(17)
    public void getAllPeopleTest(){
        List<Person> peoples = library.getAllPersons();
        assertAll(
                () -> assertNotNull(library),
                () -> assertEquals(2, peoples.size()),
                () -> assertEquals("09548936461", peoples.get(0).getCpf()),
                () -> assertEquals("37189370005", peoples.get(1).getCpf())
        );
    }

    @Test
    @Order(18)
    public void getOnePersonTest(){
        Person person = library.getOnePerson("37189370005");
        assertAll(
                () -> assertNotNull(library),
                () -> assertEquals(2, library.getAllPersons().size()),
                () -> assertEquals("Izabel Bueno", person.getName()),
                () -> assertEquals(PROFESSOR, person.getOccupation())
        );
    }

    @Test
    @Order(19)
    public void deletePersonTest(){
        boolean deleteVerify = library.deletePerson("37189370005");
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(deleteVerify),
                () -> assertNull(library.getOnePerson("37189370005"))
        );
    }

    @Test
    @Order(20)
    public void deletePersonNotExistsTest(){
        boolean deleteVerify = library.deletePerson("23823310038");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(deleteVerify)
        );
    }

    @Test
    @Order(21)
    public void addBookTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "Fantasia", authors, "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(addVerify),
                () -> assertEquals(1, library.getAllBooks().size()),
                () -> assertEquals("Corte de Espinhos e Rosas",library.getOneBook("9548ROM").getTitle())
        );
    }

    @Test
    @Order(22)
    public void addBookISBNEmptyTest(){
        boolean addVerify = library.addBook("", "Corte de Espinhos e Rosas", "Fantasia", authors, "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(23)
    public void addBookTitleEmptyTest(){
        boolean addVerify = library.addBook("9548ROM", "", "Fantasia", authors, "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(24)
    public void addBookGenreEmptyTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "", authors, "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(25)
    public void addBookAuthorEmptyTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "Fantasia", new ArrayList<> (), "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(26)
    public void addBookNumberInvalidTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "Fantasia", authors, "548pol");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(27)
    public void addBookNumberEmptyTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "Fantasia", authors, "");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(28)
    public void addBookRepeatedTest(){
        boolean addVerify = library.addBook("9548ROM", "Corte de Espinhos e Rosas", "Fantasia", authors, "548");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(addVerify)
        );
    }

    @Test
    @Order(29)
    public void addSecondyBookTest(){
        boolean addVerify = library.addBook("9549ROMA", "Corte de Névoa e Fúria", "Fantasia", authors, "748");
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(addVerify),
                () -> assertEquals(2, library.getAllBooks().size()),
                () -> assertEquals("Corte de Névoa e Fúria", library.getOneBook("9549ROMA").getTitle())
        );
    }

    @Test
    @Order(30)
    public void updateBookTest(){
        boolean updateVerify = library.updateBook("9549ROMA", "Corte de Asas e Ruina", "Fantasia", authors, "748");
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(updateVerify),
                () -> assertEquals("Corte de Asas e Ruina",library.getOneBook("9549ROMA").getTitle()),
                () -> assertEquals("Fantasia",library.getOneBook("9549ROMA").getGenre())
        );
    }

    @Test
    @Order(31)
    public void updateBookNotExistsTest(){
        boolean updateVerify = library.updateBook("789649ROM", "Corte de Asas e Ruina", "Fantasia", authors, "748");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(updateVerify)
        );
    }

    @Test
    @Order(32)
    public void getAllBookTest(){
        List<Book> books = library.getAllBooks();
        assertAll(
                () -> assertNotNull(library),
                () -> assertEquals(2, books.size()),
                () -> assertEquals("Corte de Espinhos e Rosas", books.get(0).getTitle()),
                () -> assertEquals("Corte de Asas e Ruina", books.get(1).getTitle())
        );
    }

    @Test
    @Order(33)
    public void getOneBookTest(){
        Book book = library.getOneBook("9549ROMA");
        assertAll(
                () -> assertNotNull(library),
                () -> assertEquals("Corte de Asas e Ruina", book.getTitle()),
                () -> assertEquals("Fantasia", book.getGenre())
        );
    }

    @Test
    @Order(34)
    public void deleteBookTest(){
        boolean deleteVerify = library.deleteBook("9548ROM");
        assertAll(
                () -> assertNotNull(library),
                () -> assertTrue(deleteVerify),
                () -> assertNull(library.getOneBook("9548ROM"))
        );
    }

    @Test
    @Order(35)
    public void deleteBookNotExistsTest(){
        boolean deleteVerify = library.deletePerson("23829548ROM");
        assertAll(
                () -> assertNotNull(library),
                () -> assertFalse(deleteVerify)
        );
    }

}
