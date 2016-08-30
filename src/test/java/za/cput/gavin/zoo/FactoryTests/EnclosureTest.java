package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Enclosure;
import za.cput.gavin.zoo.Domain.Show;
import za.cput.gavin.zoo.Factories.Impl.EnclosureFactoryImpl;
import za.cput.gavin.zoo.Factories.EnclosureFactory;
import za.cput.gavin.zoo.Factories.Impl.ShowFactoryImpl;
import za.cput.gavin.zoo.Factories.ShowFactory;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class EnclosureTest extends TestCase {
    private EnclosureFactory factory;
    private ShowFactory showFactory;

    public void setUp() throws Exception{
        factory = EnclosureFactoryImpl.getInstance();
        showFactory = ShowFactoryImpl.getInstance();
    }


    public void testEnclosureCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);

        Show show = showFactory.createShow("a lions Tale",start,startTime);
        Enclosure enclosure = factory.createEnclosure("cage", "Lions Den", "James",show );
        Assert.assertEquals("cage", enclosure.getType());
    }


    public void testEnclosureCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = showFactory.createShow("a lions Tale",start,startTime);
        Enclosure enclosure = factory.createEnclosure("cage", "Lions Den", "James",show);
        Assert.assertEquals("cage", enclosure.getType());

        Enclosure upodateEnclosure = new Enclosure.Builder(enclosure.getType())
                .copy(enclosure)
                .coach("Peter")
                .build();

        Assert.assertEquals("Peter", upodateEnclosure.getCoach());

    }
}
