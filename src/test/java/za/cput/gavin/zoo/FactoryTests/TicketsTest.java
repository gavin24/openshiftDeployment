package za.cput.gavin.zoo.FactoryTests;
import junit.framework.*;
import junit.framework.TestCase;


import sun.security.krb5.internal.Ticket;
import za.cput.gavin.zoo.Domain.Tickets;
import za.cput.gavin.zoo.Factories.Impl.TicketsFactoryImpl;
import za.cput.gavin.zoo.Factories.TicketsFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class TicketsTest extends TestCase {
    private TicketsFactory factory;


    public void setUp() throws Exception{
        factory = TicketsFactoryImpl.getInstance();
    }


    public void testTicketsCreation()
    {
        Date start = new Date(2013,10,13);
        Tickets ticket = factory.createTickets((long)2323, 5000,start,"Adult");
        Assert.assertEquals("Adult", ticket.getType());
    }

 
    public void testTicketsCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Tickets ticket = factory.createTickets((long)2323, 5000,start,"Adult");
        Assert.assertEquals("Adult", ticket.getType());

        Tickets upodateTickets = new Tickets.Builder(ticket.getId())
                .copy(ticket)
                .price(3000)
                .build();

        Assert.assertEquals((float)3000, upodateTickets.getPrice());

    }
}
