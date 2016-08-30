package za.cput.gavin.zoo.Factories.Impl;

import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Staff;
import za.cput.gavin.zoo.Domain.Tickets;
import za.cput.gavin.zoo.Factories.StaffFactory;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class StaffFactoryImpl implements StaffFactory{
    private static StaffFactoryImpl factory = null;

    private StaffFactoryImpl(){

    }

    public static StaffFactoryImpl getInstance(){
        if (factory == null)
            factory = new StaffFactoryImpl();

        return factory;
    }
    public Staff createStaff(Long id,Date workDay, Time endTime, Time startTime,List<Employee> employee)
    {
        Staff staff = new Staff.Builder(id).Day(workDay).endTime(endTime).startTime(startTime).employee(employee)
                .build();

        return staff;
    }
}
