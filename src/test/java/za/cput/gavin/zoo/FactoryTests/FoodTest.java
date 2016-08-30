package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Factories.Impl.FoodFactoryImpl;
import za.cput.gavin.zoo.Factories.FoodFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class FoodTest extends TestCase {
    private FoodFactory factory;


    public void setUp() throws Exception{
        factory = FoodFactoryImpl.getInstance();
    }


    public void testFoodCreation()
    {
        Date start = new Date(2013,10,13);
        Food food = factory.createFood((long) 2323, 5000, "steak", "Meat");
        Assert.assertEquals("Meat", food.getType());
    }


    public void testFoodCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Food food = factory.createFood((long) 2323, 5000, "steak", "Meat");
        Assert.assertEquals("Meat", food.getType());

        Food upodateFood = new Food.Builder(food.getId())
                .copy(food)
                .name("chicken")
                .build();
        Assert.assertEquals("chicken", upodateFood.getname());

    }
}
