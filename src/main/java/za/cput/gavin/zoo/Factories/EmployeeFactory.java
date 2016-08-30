package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface EmployeeFactory {

    Employee createEmployee(long id,String name, String surname, int age,String Country,String password,String email);
}
