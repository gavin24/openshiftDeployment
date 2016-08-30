package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface AnimalFactory {

    Animal createAnimal(long id,String name, String species, int age, String Country);

}
