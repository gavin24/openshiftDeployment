package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Schedule;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Factories.ScheduleFactory;

import java.sql.Date;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class ScheduleFactoryImpl implements ScheduleFactory{
    private static ScheduleFactoryImpl factory = null;

    private ScheduleFactoryImpl(){

    }

    public static ScheduleFactoryImpl getInstance(){
        if (factory == null)
            factory = new ScheduleFactoryImpl();

        return factory;
    }
    public  Schedule createSchedule(List<Show> show,String type, String duration, String coach)
    {
        Schedule schedule = new Schedule.Builder(type).duration(duration).coach(coach).show(show)
                .build();

        return schedule;
    }
}
