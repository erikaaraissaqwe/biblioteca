package main.models;

import main.utils.Occupation;

import java.util.Date;
import java.util.List;

public class Person {
    private String cpf;

    private String name;

    private String rua;

    private Long number;

    private String cep;

    private List<String> emails;

    private List<String> phoneNumber;

    private Date birthday;

    private Occupation occupation;

    public Person() {
    }

    public Person(String cpf, String name, String rua, Long number, String cep, List<String> emails, List<String> phoneNumber, Date birthday, Occupation occupation) {
        this.cpf = cpf;
        this.name = name;
        this.rua = rua;
        this.number = number;
        this.cep = cep;
        this.emails = emails;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.occupation = occupation;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cpf.equals(person.cpf);
    }

    @Override
    public String toString() {
        return "\nPerson:" +
                "\nCpf=" + cpf + '\n' +
                "Name=" + name + '\n' +
                "Rua=" + rua + '\n' +
                "Number=" + number +'\n'+
                "Cep=" + cep + '\n' +
                "Emails=" + emails + '\n'+
                "PhoneNumber=" + phoneNumber +'\n'+
                "Birthday=" + birthday +'\n'+
                "Occupation=" + occupation +'\n';
    }
}
