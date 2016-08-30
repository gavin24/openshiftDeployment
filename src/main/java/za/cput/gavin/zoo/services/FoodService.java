package za.cput.gavin.zoo.services;

import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Food;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public interface FoodService extends Service<Food,Long>{
    Food addFood(Food food);
    int addStock(int stock, Food food);
   int removeStock(int stock, Food food);
}
