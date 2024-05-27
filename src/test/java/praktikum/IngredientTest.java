package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.*;


public class IngredientTest {
    String name = RandomStringUtils.random(10, true, false);
    float price = new Random().nextFloat();
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);


    @Test
    public void getPrice() {
        Assert.assertEquals("Smth is wrong with the getPrice method", ingredient.price, ingredient.getPrice(), 0.001);

    }

    @Test
    public void getName() {
        Assert.assertEquals("Smth is wrong with the getName method", ingredient.name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());

    }
}