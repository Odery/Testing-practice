package com.vakamisu.testing;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewCoffee(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(20);
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //check if its truly espresso
        Assert.assertEquals(CoffeeType.Espresso,coffee.getType());
        Assert.assertEquals(0,coffee.getMilk());
        Assert.assertEquals(7,coffee.getBeans());

    }
}
