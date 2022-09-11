package data.factory;

import data.factory.models.User;

public class UserBuilder {

    private String surname;
    private String name;
    private String email;
    private String city;

    public UserBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public User build(){
        return new User(surname,name, email, city);
    }
    
}
