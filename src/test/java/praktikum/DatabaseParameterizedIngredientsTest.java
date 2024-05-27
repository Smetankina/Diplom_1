package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DatabaseParameterizedIngredientsTest {
    private final int index;
    private final IngredientType type;
    private final String name;
    private final float price;

    Database database = new Database();


    public DatabaseParameterizedIngredientsTest(int index, IngredientType type, String name, float price) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {0, IngredientType.SAUCE, "hot sauce", 100},
                {1, IngredientType.SAUCE, "sour cream", 200},
                {2, IngredientType.SAUCE, "chili sauce", 300},
                {3, IngredientType.FILLING, "cutlet", 100},
                {4, IngredientType.FILLING, "dinosaur", 200},
                {5, IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void availableIngredientsNameTest() {
        Assert.assertEquals("There are some changes were in database name for " + database.availableIngredients().get(index).getName(), database.availableIngredients().get(index).getName(), name);
    }


    @Test
    public void availableIngredientsPriceTest() {
        Assert.assertEquals("There are some changes were in database price for " + database.availableIngredients().get(index).getName(), database.availableIngredients().get(index).getPrice(), price, 0.001);
    }


}
