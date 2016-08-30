package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Tickets;
import za.cput.gavin.zoo.Factories.TicketsFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class TicketsFactoryImpl implements TicketsFactory{
    private static TicketsFactoryImpl factory = null;

    private TicketsFactoryImpl(){

    }

    public static TicketsFactoryImpl getInstance(){
        if (factory == null)
            factory = new TicketsFactoryImpl();

        return factory;
    }


    public  Tickets createTickets(Long id,float price, Date day, String ticketType)
    {
        Tickets ticket = new Tickets.Builder(id).price(price).day(day).type(ticketType)
                .build();

        return ticket;
    }
}
