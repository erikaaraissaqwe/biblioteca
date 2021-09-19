package test.models;

import main.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static main.utils.Occupation.ALUNO;
import static main.utils.Occupation.PROFESSOR;

public class PersonTest {
    ArrayList<String> emails = new ArrayList<>(Arrays.asList("erikaaraissaqwe@gmail.com"));
    ArrayList<String> phones = new ArrayList<>(Arrays.asList("16 99254-9652"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataUsuario;

    private Date dateUser(String data) {
        try {
            return dataUsuario = sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    Person principal = new Person("095.489.364-61", "Erika Raissa Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, dateUser("17/07/2000"), ALUNO);

    @Test
    public void testCreateNewPerson() {
        Person p = new Person("095.489.364-61", "Erika Raissa Bueno", "Rua das Alamedas", 85L, "14815-000", emails, phones, dateUser("17/07/2000"), ALUNO);
        Assertions.assertEquals(p, principal);
    }

    @Test
    public void testGetCpf() {
        Assertions.assertEquals("095.489.364-61", principal.getCpf());
    }

    @Test
    public void testSetCpf() {
        principal.setCpf("05802820403");
        Assertions.assertEquals("05802820403", principal.getCpf());
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Erika Raissa Bueno", principal.getName());
    }

    @Test
    public void testSetName() {
        principal.setName("Erika Raissa Bueno da Silva");
        Assertions.assertEquals("Erika Raissa Bueno da Silva", principal.getName());
    }

    @Test
    public void testGetRua() {
        Assertions.assertEquals("Rua das Alamedas", principal.getRua());
    }

    @Test
    public void testSetRua() {
        principal.setRua("Rua dos Alfineiros");
        Assertions.assertEquals("Rua dos Alfineiros", principal.getRua());
    }

    @Test
    public void testGetNumber() {
        Assertions.assertEquals(85L, principal.getNumber());
    }

    @Test
    public void testSetNumber() {
        principal.setNumber(859L);
        Assertions.assertEquals(859L, principal.getNumber());
    }

    @Test
    public void testGetCep() {
        Assertions.assertEquals("14815-000", principal.getCep());
    }

    @Test
    public void testSetCep() {
        principal.setCep("56200-000");
        Assertions.assertEquals("56200-000", principal.getCep());
    }

    @Test
    public void testGetEmails() {
        Assertions.assertEquals(emails, principal.getEmails());
    }

    @Test
    public void testSetEmails() {
        ArrayList<String> emails2 = new ArrayList<>(Arrays.asList("erikaaraissaqwe@gmail.com", "erika@gmail.com", "raissaqwe@gmail.com"));
        principal.setEmails(emails2);
        Assertions.assertArrayEquals(new ArrayList[]{emails2}, new ArrayList[]{(ArrayList) principal.getEmails()});
    }

    @Test
    public void testGetPhoneNumber() {
        Assertions.assertEquals(phones, principal.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        ArrayList<String> phones2 = new ArrayList<>(Arrays.asList("16 99254-9652", "87 99254-9652"));
        principal.setPhoneNumber(phones2);
        Assertions.assertArrayEquals(new ArrayList[]{phones2}, new ArrayList[]{(ArrayList) principal.getPhoneNumber()});
    }

    @Test
    public void testGetBirthday() {
        Assertions.assertEquals(dateUser("17/07/2000"), principal.getBirthday());
    }

    @Test
    public void testSetBirthday() {
        principal.setBirthday(dateUser("18/08/2000"));
        Assertions.assertEquals(dateUser("18/08/2000"), principal.getBirthday());
    }

    @Test
    public void testGetOccupation() {
        Assertions.assertEquals(ALUNO, principal.getOccupation());
    }

    @Test
    public void testSetOccupation() {
        principal.setOccupation(PROFESSOR);
        Assertions.assertEquals(PROFESSOR, principal.getOccupation());
    }
}
