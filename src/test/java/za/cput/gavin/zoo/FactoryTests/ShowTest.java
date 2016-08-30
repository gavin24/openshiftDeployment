package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Factories.Impl.ShowFactoryImpl;
import za.cput.gavin.zoo.Factories.ShowFactory;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class ShowTest extends TestCase {
    private ShowFactory factory;


    public void setUp() throws Exception{
        factory = ShowFactoryImpl.getInstance();
    }


    public void testShowCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = factory.createShow("A Lions Tale", start, startTime);
        Assert.assertEquals("A Lions Tale", show.getname());
    }


    public void testShowCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = factory.createShow("A Lions Tale", start, startTime);
        Assert.assertEquals("A Lions Tale", show.getname());
        Date newStart = new Date(2015,10,13);
        Show upodateShow = new Show.Builder(show.getname())
                .copy(show)
                .day(newStart)
                .build();

        Assert.assertEquals(newStart, upodateShow.getDay());

    }
}
