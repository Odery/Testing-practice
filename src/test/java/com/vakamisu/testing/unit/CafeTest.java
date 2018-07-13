package com.vakamisu.testing.unit;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.vakamisu.testing.unit.CoffeeType.Espresso;
import static com.vakamisu.testing.unit.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CafeTest {

    private static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    private static final int NO_MILK = 0;
    private static final int NO_BEANS = 0;

    private Cafe cafe;

    @Before
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewCoffee(){
        //Given
        withBeans();

        //When
        Coffee coffee = cafe.brew(Espresso);

        //Then
        assertThat(coffee, Matchers.hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));
        assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());

    }

    @Test
    public void canBrewLatte() {
        //Given
        withBeans();
        cafe.restockMilk(Latte.getRequiredMilk());

        //When
        Coffee coffee = cafe.brew(Latte);

        //Then
        assertEquals("Wrong coffee type", Latte, coffee.getType());
    }

    @Test
    public void brewingConsumeBeans() {
        //Given
        withBeans();

        //When
        Coffee coffee = cafe.brew(Espresso);

        //Then
        assertEquals("Beans not consuming", NO_BEANS, cafe.getBeansInStock());
    }

    //Then
    @Test(expected = IllegalStateException.class)
    public void latteRequireMilk() {
        //Given
        withBeans();

        //When
        cafe.brew(Latte);
    }

    //Then
    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        //Given
        Cafe cafe = new Cafe();

        //When
        cafe.restockMilk(CafeTest.NO_MILK);
    }

    //Then
    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        //Given
        Cafe cafe = new Cafe();

        //When
        cafe.restockBeans(NO_BEANS);
    }

    private void withBeans() {
        cafe.restockBeans(Espresso.getRequiredBeans());
    }
}
