package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface FoodFactory {

    Food createFood(long id,float price,String name, String type,int stock);
}
