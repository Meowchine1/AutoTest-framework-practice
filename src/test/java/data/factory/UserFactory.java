package data.factory;

import com.github.javafaker.Faker;
import data.factory.models.User;

public class UserFactory {
    private static Faker faker = new Faker();
    private static int randomNum = 12;
    private static int maxLastNameLength = 100;
    private static int maxNameLength = 100;
    private static int maxCityLength = 120;
    private static int maxEmailHostLength = 63;
    private static int maxEmailFirstDomainLength = 63;
    private static final String[] invalidEmails = new String[]{"mysite@.com.my", "@you.me.net", "mysite123@gmail.b",
            "mysite@.org.org", ".mysite@mysite.org", "mysite()*@gmail.com", "mysite..1234@yahoo.com"};
    private static final String[] validEmails = new String[]{"mysite@ourearth.com","my.ownsite@ourearth.org",
            "mysite@you.me.net"};

    private UserFactory(){}

    public static User[] createUsersWithInvalidEmail(){
        User[] users = new User[invalidEmails.length];
       for(int i = 0 ; i< invalidEmails.length; i++){
           users[i] = new User(faker.name().lastName(),
                   faker.name().firstName(),
                   invalidEmails[i],
                   faker.address().city());
       }
        return users;
    }
    public static User[] createUsersWithValidEmail(){
        User[] users = new User[validEmails.length];
       for(int i = 0 ; i< validEmails.length; i++){
           users[i] = new User(faker.name().lastName(),
                   faker.name().firstName(),
                   validEmails[i],
                   faker.address().city());
       }
        return users;
    }


    public static User createValidUser(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }

    public static User createUserWithEmptyName(){
        return new User(faker.name().lastName(),
                "",
                faker.internet().emailAddress(),
                faker.address().city());
    }
    public static User createUserWithEmptyLastName(){
        return new User("",
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }

    public static User createUserWithEmptyEmail(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                "",
                faker.address().city());
    }

    public static User createUserWithEmptyCity(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                "");
    }

    public static User createUserWithSpaceName(){
        return new User(faker.name().lastName(),
                faker.regexify("[ ]{" + randomNum + "}"),
                faker.internet().emailAddress(),
                faker.address().city());
    }
    public static User createUserWithSpaceLastName(){
        return new User(faker.regexify("[ ]{" + randomNum + "}"),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }

    public static User createUserWithSpaceCity (){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.regexify("[ ]{" + randomNum + "}");
    }
    public static User createUserWithSpaceEmail (){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.regexify("[ ]{" + randomNum + "}"),
                faker.address().city());
    }

    public static User createUserWithTooLongName(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }
    public static User createUserWithTooLongSurname(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }
    public static User createUserWithTooLongCity(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }
    public static User createUserWithTooLongEmail(){
        return new User(faker.name().lastName(),
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.address().city());
    }


}
