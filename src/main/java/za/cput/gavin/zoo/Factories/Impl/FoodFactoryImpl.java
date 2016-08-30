package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Factories.FoodFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class FoodFactoryImpl implements FoodFactory{
    private static FoodFactoryImpl factory = null;

    private FoodFactoryImpl(){

    }

    public static FoodFactoryImpl getInstance(){
        if (factory == null)
            factory = new FoodFactoryImpl();

        return factory;
    }
    public Food createFood(long id,float price,String name, String type,int stock)
    {
        Food food = new Food.Builder().id(id).price(price).name(name).type(type).stock(stock)
                .build();

        return food;
    }
}
