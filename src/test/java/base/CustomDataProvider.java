package base;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomDataProvider {

    @DataProvider(name = "validSearch", parallel = true)
    public static Object[][] searchRequest() {
        return new Object[][]{{"курс"}, {"информация"}, {"2012"}, {"у"},
                {"икт"}};
    }

    @DataProvider(name = "invalidSearch", parallel = true)
    public static Object[][] invalidSearch() {
        return new Object[][]{{""}, {"#"}, {"&&&&&^^^"}, {"%"}, {"   "}
        };
    }

    @DataProvider(name = "longRequest", parallel = true)
    public static Object[][] longRequest() {
        return new Object[][]{{19}, {20}, {21}, {50}
        };
    }

    @DataProvider(name = "correctPhoto", parallel = false)
    public static Object[][] correctPhoto() {
        String path = "src/test/java/data/correctSizePhoto/";
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

    ;
}




