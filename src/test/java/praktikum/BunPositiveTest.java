package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
public class BunPositiveTest {
    private final String name;
    private final float price;

    public BunPositiveTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
//так как информации точной о валидных значениях булки нет, руководствовалась тем, что увидела на UI
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
              //точной минимальной длины названия не дано, предположим, что 1 символ, цена положительное float
                { RandomStringUtils.random(1, true, false), new Random().nextFloat()*new Random().nextInt(100) },
                //точной максимальной длины названия не дано, предположим, что 100 символов
                { RandomStringUtils.random(100, true, false), new Random().nextFloat()*new Random().nextInt(100) },
                //название может включать цифры, цена положительный float
                { RandomStringUtils.random(10, true, true), new Random().nextFloat()*new Random().nextInt(1000) },
                //название может включать пробел в середине, цена положительный float
                { RandomStringUtils.random(10, true, true), new Random().nextFloat()*new Random().nextInt(1000) },
                //название может включать пробел в середине, цена положительный float
                { RandomStringUtils.random(10, true, true)+" " + RandomStringUtils.random(10, true, true), new Random().nextFloat()*new Random().nextInt(100) },
                //название может включать тире, цена положительный float
                { RandomStringUtils.random(5, true, true)+"-" + RandomStringUtils.random(4, true, true), new Random().nextFloat() },
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