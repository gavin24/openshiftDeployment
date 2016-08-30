package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface ShowFactory {

    Show createShow(String name, Date showDay, Time showTime);
}
