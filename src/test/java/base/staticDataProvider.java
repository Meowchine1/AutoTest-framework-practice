package base;

import org.testng.annotations.DataProvider;

public class staticDataProvider {

    @DataProvider(name = "validSearch", parallel = true)
    public static Object[][] searchRequest() {
        return new Object[][] {{"курс"}, {"информация"}, {"2012"}, {"у"},
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
}
