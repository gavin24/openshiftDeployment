package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Schedule;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface ScheduleFactory {

    Schedule createSchedule(List<Show> show,String type, String duration, String coach);
}
