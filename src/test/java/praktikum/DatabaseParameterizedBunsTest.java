package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DatabaseParameterizedBunsTest {
    private final int index;
    private final String nameBun;
    private final float priceBun;

    Database database = new Database();

    public DatabaseParameterizedBunsTest(int index, String nameBun, float priceBun) {
        this.index = index;
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[][] bunParameters() {
        return new Object[][]{
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300}
        };
    }


    @Test
    public void availableBunsPriceTest() {
        Assert.assertEquals("There are some changes were in database price for " + database.availableBuns().get(index).getName(), database.availableBuns().get(index).getPrice(), priceBun, 0.001);
    }


    @Test
    public void availableBunsNameTest() {
        Assert.assertEquals("There are some changes were in database name for " + database.availableBuns().get(index).getName(), database.availableBuns().get(index).getName(), nameBun);
    }

}