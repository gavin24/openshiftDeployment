package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Factories.FoodFactory;
import za.cput.gavin.zoo.Factories.Impl.AnimalFactoryImpl;
import za.cput.gavin.zoo.Factories.AnimalFactory;
import za.cput.gavin.zoo.Factories.Impl.FoodFactoryImpl;
import za.cput.gavin.zoo.Factories.ShowFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class AnimalTest extends TestCase {
    private AnimalFactory factory;
    private FoodFactory foodFactory;

    public void setUp() throws Exception{
        factory = AnimalFactoryImpl.getInstance();
        foodFactory = FoodFactoryImpl.getInstance();
    }


    public void testAnimalCreation()
    {
        Date start = new Date(2013,10,13);
        Food food = foodFactory.createFood((long)12,50,"steak","meat",6);
        Animal animal = factory.createAnimal((long) 2323, "Borris", "Mammal", 23,"Russia",food);
        Assert.assertEquals("Borris", animal.getName());
    }


    public void testAnimalCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Food food = foodFactory.createFood((long)12,50,"steak","meat",5);
        Animal animal = factory.createAnimal((long) 2323, "Borris", "Mammal", 23,"Russia",food);
        Assert.assertEquals("Borris", animal.getName());

        Animal upodateAnimal = new Animal.Builder(animal.getId())
                .copy(animal)
                .Country("China")
                .build();

        Assert.assertEquals("China", upodateAnimal.getCountry());

    }
}
