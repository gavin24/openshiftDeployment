package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface TicketsFactory {
    Tickets createTickets(Long id,float price, Date day, String ticketType);
}
