package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { RandomStringUtils.random(10, true, false), new Random().nextFloat() },
                { RandomStringUtils.random(10, true, false),  new Random().nextFloat() },
        };
    }

    @Test
    public void getName() {

        Bun bun = new Bun(name, price);
        Assert.assertEquals("Expected name doesn't match with actual name",name, bun.getName());
    }


    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Something is wrong with the getPrice method",price,bun.getPrice(), 0.001);
    }
}