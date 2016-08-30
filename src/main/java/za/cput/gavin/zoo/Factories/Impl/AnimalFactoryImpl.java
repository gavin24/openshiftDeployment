package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Factories.AnimalFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class AnimalFactoryImpl implements AnimalFactory {
    private static AnimalFactoryImpl factory = null;

    private AnimalFactoryImpl(){

    }

    public static AnimalFactoryImpl getInstance(){
        if (factory == null)
            factory = new AnimalFactoryImpl();

        return factory;
    }
    @Override
    public Animal createAnimal(long id,String name, String species, int age, String Country)//,Food food)
    {
        Animal animal = new Animal.Builder().id(id).name(name).species(species).age(age).Country(Country)//.food(food)
                .build();

        return animal;
    }
}
