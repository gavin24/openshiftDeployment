package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Enclosure;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface EnclosureFactory {

    Enclosure createEnclosure(String type,String name, String coach, Show show);
}
