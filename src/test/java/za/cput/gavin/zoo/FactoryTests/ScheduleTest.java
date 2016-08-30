package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Schedule;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Domain.Schedule;
import za.cput.gavin.zoo.Factories.Impl.ScheduleFactoryImpl;
import za.cput.gavin.zoo.Factories.Impl.ShowFactoryImpl;
import za.cput.gavin.zoo.Factories.ScheduleFactory;
import za.cput.gavin.zoo.Factories.ShowFactory;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class ScheduleTest extends TestCase {
    private ScheduleFactory factory;
    private ShowFactory showFactory;

    public void setUp() throws Exception{
        factory = ScheduleFactoryImpl.getInstance();
        showFactory = ShowFactoryImpl.getInstance();
    }


    public void testScheduleCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        List<Show> show = new ArrayList<Show>();
        Show shows =   showFactory.createShow("a lions Tale",start,startTime);
        show.add(shows);
        Schedule schedule = factory.createSchedule(show , "qwe", "5 hours", "Anna");
        Assert.assertEquals("qwe", schedule.getType());
    }


    public void testScheduleCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        List<Show> show = new ArrayList<Show>();
        Show shows =   showFactory.createShow("a lions Tale",start,startTime);
        show.add(shows);
        Schedule schedule = factory.createSchedule(show , "qwe", "5 hours", "Anna");
        Assert.assertEquals("qwe", schedule.getType());

        Schedule upodateSchedule = new Schedule.Builder(schedule.getDuration())
                .copy(schedule)
                .coach("Peter")
                .build();

        Assert.assertEquals("Peter", upodateSchedule.getCoach());

    }
}
