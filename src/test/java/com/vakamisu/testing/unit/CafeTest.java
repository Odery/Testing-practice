package com.vakamisu.testing.unit;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder
public class CafeTest {

    @Test
    public void canBrewCoffee(){

        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(20);

        //When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //Then
        Assert.assertEquals(CoffeeType.Espresso,coffee.getType());
        Assert.assertEquals(0,coffee.getMilk());
        Assert.assertEquals(7,coffee.getBeans());

    }

    @Test
    public void brewingConsumeBeans() {
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //Then
        Assert.assertEquals(0, cafe.getBeansInStock());
    }

    //Then
    @Test(expected = IllegalStateException.class)
    public void latteRequireMilk() {
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //When
        cafe.brew(CoffeeType.Latte);
    }

}
