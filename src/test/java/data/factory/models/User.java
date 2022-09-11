package data.factory.models;

public class User {
    private String surname;
    private String name;
    private String email;
    private String city;

    public User(String surname, String name, String email, String city) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
