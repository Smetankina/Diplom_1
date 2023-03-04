package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
public class BunNegativeTest {
    private final String name;
    private final float price;

    public BunNegativeTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {

                //name - пустая строка, price - наименьшее положительное
                { "",  0.01f },
                //name - null, price 0.00
                {null, 0.00f},
                //строка длинной 101 символов, price максимально положительная
                { RandomStringUtils.random(101, true, false), 999999999.99f },
                //спецсимволы в названии, price - отрицательное
                { RandomStringUtils.random(5, true, false)+"$", -97.8751f },
        };
    }

    //созданы разннобразные тестовые проверки, а вот насколько это верное поведение, это уже нужно уточнять

    @Test
    public void getName(){

        Bun bun = new Bun(name, price);
        Assert.assertEquals("Expected name doesn't match with actual name",name, bun.getName());

    }


    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Expected name doesn't match with actual name",name, bun.getName());

    }
}