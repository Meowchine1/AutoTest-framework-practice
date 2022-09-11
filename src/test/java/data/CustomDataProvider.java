package data;

import browserDriver.BrowserType;
import data.factory.UserFactory;
import data.factory.models.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomDataProvider {
    private static int numberOfUserParameters = 4;

    private static final User[] validUsers = new User[]{};
    private static final User[] invalidUsers = new User[]{
            UserFactory.createUserWithEmptyCity(),
            UserFactory.createUserWithEmptyLastName(),
            UserFactory.createUserWithEmptyName(),
            UserFactory.createUserWithEmptyEmail(),
            UserFactory.createUserWithSpaceCity(),
            UserFactory.createUserWithSpaceLastName(),
            UserFactory.createUserWithSpaceName(),
            UserFactory.createUserWithSpaceEmail(),
            UserFactory.createUserWithTooLongCity(),
            UserFactory.createUserWithTooLongName(),
            UserFactory.createUserWithTooLongSurname(),
            UserFactory.createUserWithTooLongEmail()};

    @DataProvider(name = "correctPhoto", parallel = false)
    public static Object[][] correctPhoto() {
        String path = "src/test/java/data/correctSizePhoto/"; // -
        File dir = new File(path);
        List<String> list = Arrays.asList(Objects.requireNonNull(dir.list()));
        Object[][] result = new Object[list.size()][1];
        int i = 0;
        for (String elem : list) {
            result[i][0] = path + elem;
            i++;
        }
        return result;
    }

    @DataProvider(name = "validEmail")
    public static Object[][] validLoginData(){
        Object[][] users = new Object[invalidUsers.length][numberOfUserParameters];
        for (int i = 0; i < invalidUsers.length; i++){

                users[i][0] = invalidUsers[i].getSurname();
                users[i][1] = invalidUsers[i].getName();
                users[i][2] = invalidUsers[i].getCity();
                users[i][3] = invalidUsers[i].getEmail();


        }
        return users;

    }

    @DataProvider(name = "invalidEmail")
    public static Object[][] invalidLoginData(){
        Object[][] users = new Object[validUsers.length][numberOfUserParameters];
        for (int i = 0; i < validUsers.length; i++){

            users[i][0] = validUsers[i].getSurname();
            users[i][1] = validUsers[i].getName();
            users[i][2] = validUsers[i].getCity();
            users[i][3] = validUsers[i].getEmail();


        }
        return users;
    }


}




