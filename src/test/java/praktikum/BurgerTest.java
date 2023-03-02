package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.indexOf;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Spy
    List<Ingredient> ingredients;

    Burger burger = new Burger();


    @Test
    public void setBunsTest() {

        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);

    }


    @Test
    public void addIngredientTest() {

        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));

    }

    @Test
    public void moveIngredient() {
        String ingredient1Name = RandomStringUtils.random(10, true, false);
        String ingredient2Name = RandomStringUtils.random(10, true, false);
        float ingredientPrice = new Random().nextFloat();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, ingredient1Name, ingredientPrice));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, ingredient2Name, ingredientPrice));

        burger.moveIngredient(1, 0);

        Assert.assertEquals(burger.ingredients.get(0).name, ingredient2Name);


    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getPrice();
        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient).getPrice();

    }

    @Test
    public void getPriceBurger() {
        float bunPrice = new Random().nextFloat();
        float ingredientPrice = new Random().nextFloat();


        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        float burgerPrice = bunPrice * 2 + ingredientPrice;
        Assert.assertEquals(burger.getPrice(), burgerPrice, 0.001);
    }

    @Test
    public void getReceipt() {
        String bunName = RandomStringUtils.random(10, true, false);
        float bunPrice = new Random().nextFloat();
        String ingredientName = RandomStringUtils.random(10, true, false);
        float ingredientPrice = new Random().nextFloat();

        burger.setBuns(new Bun(bunName, bunPrice));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice));
        float burgerPrice = bunPrice * 2 + ingredientPrice;


        String receipt = "(==== " + bunName + " ====)\r\n" +
                "= sauce " + ingredientName + " =\r\n" +
                "(==== " + bunName + " ====)\r\n" +
                "\r\n" +
                "Price: " + String.format("%.6f", burgerPrice) + "\r\n";

        Assert.assertEquals(receipt, burger.getReceipt());
    }


}