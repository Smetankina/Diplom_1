package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class DatabaseTest {


    Database database = new Database();


    @Test
    public void availableBunsCountTest() {

        Assert.assertEquals("Final list of buns contains 3 buns type", 3, database.availableBuns().size());
    }

    @Test
    public void availableBuns() {
        Assert.assertFalse("List of buns is empty", database.availableBuns().isEmpty());
    }


    @Test
    public void availableBunsMatchTest() {

        Assert.assertEquals("Price of " + database.availableBuns().get(0).name + " is  match", 100, database.availableBuns().get(0).price, 0.001);
        Assert.assertEquals("Price of " + database.availableBuns().get(1).name + " is  match", 200, database.availableBuns().get(1).price, 0.001);
        Assert.assertEquals("Price of " + database.availableBuns().get(2).name + " is  match", 300, database.availableBuns().get(2).price, 0.001);
    }


    @Test
    public void availableIngredients() {
        Assert.assertFalse("List of ingredients is empty", database.availableIngredients().isEmpty());
    }
}