package models;

import main.models.Person;
import main.utils.DataValidator;
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


import static main.utils.Occupation.ALUNO;
import static main.utils.Occupation.PROFESSOR;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

    private Person principal;
    ArrayList<String> phones;
    ArrayList<String> emails;

    @BeforeAll
    public void createStudent(){
        emails = new ArrayList<>(List.of("erikaaraissaqwe@gmail.com"));
        phones = new ArrayList<>(List.of("16 99254-9652"));
        principal = new Person("09548936461", "Erika Raissa Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, DataValidator.formatStringInDate("17/07/2000"), ALUNO);
    }

    @Test
    @DisplayName("Teste - Linux")
    @EnabledOnOs({OS.LINUX})
    @Order(21)
    void testSetNomeParaLinux(){
        Person p = new Person();
        p.setName("Izabel");
        String expected = "Izabel";
        assertEquals(expected, p.getName());
    }

    @Test
    @DisplayName("Teste - Windows")
    @EnabledOnOs({OS.WINDOWS})
    @Order(22)
    void testSetCepParaWindows(){
        Person p = new Person();
        p.setCep("5596523");
        String expected ="5596523";
        assertEquals(expected, p.getCep());
    }

    @Test
    @DisplayName("Teste - Java 8")
    @EnabledOnJre(JRE.JAVA_8)
    @Order(25)
    void testSetCpfParaJRE8(){
        Person p = new Person();
        p.setCpf("55965232696");
        String expected ="55965232696";
        assertEquals(expected, p.getCep());
    }

    @DisplayName("Teste - Java 11")
    @EnabledOnJre(JRE.JAVA_11)
    @ParameterizedTest
    @ValueSource(strings = {"09658932162", "96523665123", "9564596312"})
    @Order(26)
    void testSetCpfParaJRE11(String str){
        Person p = new Person();
        p.setCpf(str);
        assertEquals(str, p.getCpf());
    }

    @DisplayName("Teste parametrizado para getName")
    @ParameterizedTest
    @ValueSource(strings = {"Erika", "Raissa", "Bueno"})
    @Order(23)
    void testGetNameParametrizado(String str){
        Person newPerson = new Person();
        newPerson.setName(str);
        assertEquals(str, newPerson.getName());
    }

    @DisplayName("Teste parametrizado para setRua")
    @ParameterizedTest
    @ValueSource(strings = {"Rua das Terras", "Av. Raissa", "Rua Professor Bueno"})
    @Order(24)
    void testSetRuaParametrizado(String str){
        Person newPerson = new Person();
        newPerson.setRua(str);
        assertEquals(str, newPerson.getRua());
    }

    @Test
    @DisplayName("Testa se o nome e o cpf são iguais")
    @Order(1)
    public void testGets(){
        assertAll(
                () -> assertNotNull(principal),
                () -> assertEquals("Erika Raissa Bueno", principal.getName()),
                () -> assertEquals("09548936461",principal.getCpf())
        );
    }

    @Test
    @DisplayName("Testa getCPF do person principal - aluno")
    @Order(2)
    public void testGetCpf() {
        Assertions.assertEquals("09548936461", principal.getCpf());
    }

    @Test
    @DisplayName("Testa setCPF do person principal - aluno")
    @Order(3)
    public void testSetCpf() {
        principal.setCpf("05802820403");
        Assertions.assertEquals("05802820403", principal.getCpf());
    }

    @Test
    @DisplayName("Testa getName do person principal - aluno")
    @Order(4)
    public void testGetName() {
        Assertions.assertEquals("Erika Raissa Bueno", principal.getName());
    }

    @Test
    @DisplayName("Testa setName do person principal - aluno")
    @Order(5)
    public void testSetName() {
        principal.setName("Erika Raissa Bueno da Silva");
        Assertions.assertEquals("Erika Raissa Bueno da Silva", principal.getName());
    }

    @Test
    @DisplayName("Testa getRua do person principal - aluno")
    @Order(6)
    public void testGetRua() {
        Assertions.assertEquals("Rua das Alamedas", principal.getRua());
    }

    @Test
    @DisplayName("Testa setRua do person principal - aluno")
    @Order(7)
    public void testSetRua() {
        principal.setRua("Rua dos Alfineiros");
        Assertions.assertEquals("Rua dos Alfineiros", principal.getRua());
    }

    @Test
    @DisplayName("Testa getNumber do person principal - aluno")
    @Order(8)
    public void testGetNumber() {
        Assertions.assertEquals(85L, principal.getNumber());
    }

    @Test
    @DisplayName("Testa setNumber do person principal - aluno")
    @Order(9)
    public void testSetNumber() {
        principal.setNumber(859L);
        Assertions.assertEquals(859L, principal.getNumber());
    }

    @Test
    @DisplayName("Testa getCep do person principal - aluno")
    @Order(10)
    public void testGetCep() {
        Assertions.assertEquals("14815-000", principal.getCep());
    }

    @Test
    @DisplayName("Testa setCep do person principal - aluno")
    @Order(11)
    public void testSetCep() {
        principal.setCep("56200-000");
        Assertions.assertEquals("56200-000", principal.getCep());
    }

    @Test
    @DisplayName("Testa getEmails do person principal - aluno")
    @Order(12)
    public void testGetEmails() {
        Assertions.assertEquals(emails, principal.getEmails());
    }

    @Test
    @DisplayName("Testa setEmails do person principal - aluno")
    @Order(13)
    public void testSetEmails() {
        ArrayList<String> emails2 = new ArrayList<>(Arrays.asList("erikaaraissaqwe@gmail.com", "erika@gmail.com", "raissaqwe@gmail.com"));
        principal.setEmails(emails2);
        Assertions.assertArrayEquals(new ArrayList[]{emails2}, new ArrayList[]{(ArrayList) principal.getEmails()});
    }

    @Test
    @DisplayName("Testa getTelefones do person principal - aluno")
    @Order(14)
    public void testGetPhoneNumber() {
        Assertions.assertEquals(phones, principal.getPhoneNumber());
    }

    @Test
    @DisplayName("Testa setTelefones do person principal - aluno")
    @Order(15)
    public void testSetPhoneNumber() {
        ArrayList<String> phones2 = new ArrayList<>(Arrays.asList("16 99254-9652", "87 99254-9652"));
        principal.setPhoneNumber(phones2);
        Assertions.assertArrayEquals(new ArrayList[]{phones2},
                new ArrayList[]{(ArrayList) principal.getPhoneNumber()});
    }

    @Test
    @DisplayName("Testa getBirthday do person principal - aluno")
    @Order(16)
    public void testGetBirthday() {
        Assertions.assertEquals(DataValidator.formatStringInDate("17/07/2000"), principal.getBirthday());
    }

    @Test
    @DisplayName("Testa setBirthday do person principal - aluno")
    @Order(17)
    public void testSetBirthday() {
        principal.setBirthday(DataValidator.formatStringInDate("18/08/2000"));
        Assertions.assertEquals(DataValidator.formatStringInDate("18/08/2000"), principal.getBirthday());
    }

    @Test
    @DisplayName("Testa getOccupation do person principal - aluno")
    @Order(18)
    public void testGetOccupation() {
        Assertions.assertEquals(ALUNO, principal.getOccupation());
    }

    @Test
    @DisplayName("Testa setOccupation do person principal - aluno")
    @Order(19)
    public void testSetOccupation() {
        principal.setOccupation(PROFESSOR);
        Assertions.assertEquals(PROFESSOR, principal.getOccupation());
    }

    @Test
    @DisplayName("Testa a criação de uma nova pessoa - professor")
    @Order(20)
    public void testCreateNewPerson() {
        Person p = new Person("09548934418", "Erika Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, DataValidator.formatStringInDate("17/07/1980"), PROFESSOR);
        assertAll(
                () -> assertNotNull(p),
                () -> assertEquals("Erika Bueno", p.getName()),
                () -> assertEquals("09548934418",p.getCpf()),
                () -> assertEquals(PROFESSOR, p.getOccupation()),
                () -> assertEquals("Rua das Alamedas", p.getRua())
        );
    }

    @Test
    @DisplayName("Testa o equals do Person")
    @Order(27)
    public void testEqualsPerson() {
        Person p = new Person("05802820403", "Erika Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, DataValidator.formatStringInDate("17/07/1980"), ALUNO);
        assertTrue(p.equals(principal));
    }

    @Test
    @DisplayName("Testa o toString do Person")
    @Order(28)
    public void testToStringPerson() {
        Person p = new Person("09548936461", "Erika Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, DataValidator.formatStringInDate("17/07/1980"), ALUNO);
        String personForToString = "\nPerson:" +
                "\nCpf=" + p.getCpf() + '\n' +
                "Name=" + p.getName() + '\n' +
                "Rua=" + p.getRua() + '\n' +
                "Number=" + p.getNumber() +'\n'+
                "Cep=" + p.getCep() + '\n' +
                "Emails=" + p.getEmails() + '\n'+
                "PhoneNumber=" + p.getPhoneNumber() +'\n'+
                "Birthday=" + DataValidator.formatDateInString(p.getBirthday()) +'\n'+
                "Occupation=" + p.getOccupation() +'\n';
        assertEquals(personForToString, p.toString());
    }
}
