package za.cput.gavin.zoo.Factories;

import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Staff;
import za.cput.gavin.zoo.Domain.Tickets;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public interface StaffFactory {


    Staff createStaff(Long id,Date workDay, Time endTime, Time startTime,List<Employee> employee);
}
