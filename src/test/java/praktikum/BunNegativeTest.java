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

                //name - пустая строка, price - пустая строка
                { "",  "" },
                //name - null, price -null
                {null, null},
                //строка длинной 50 символов, price double
                { RandomStringUtils.random(101, true, false), new Random().nextFloat(50)*10,0000001 },
                //спецсимволы в названии, price - отрицательное
                { RandomStringUtils.random(5, true, false)+"$", -97.8751 },
        };
    }
//не совсем понимаю, как правильно написать тест, если булка вообще не создается, но она и не должна создаваться по конструктору класса
    //получается мы и нашли, что в классе негатив не учтен
    @Test
    public void getName(){

        Bun bun = new Bun(name, price);
        Assert.assertNull("Bun cant be created", bun);

    }


    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertNull("Bun cant be created", bun);

    }
}