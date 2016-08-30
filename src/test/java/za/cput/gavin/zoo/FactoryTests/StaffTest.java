package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Staff;
import za.cput.gavin.zoo.Factories.EmployeeFactory;
import za.cput.gavin.zoo.Factories.Impl.EmployeeFactoryImpl;
import za.cput.gavin.zoo.Factories.Impl.StaffFactoryImpl;
import za.cput.gavin.zoo.Factories.StaffFactory;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class StaffTest extends TestCase {
    private StaffFactory factory;
    private EmployeeFactory employeeFactory;

    public void setUp() throws Exception{
        factory = StaffFactoryImpl.getInstance();
        employeeFactory = EmployeeFactoryImpl.getInstance();
    }


    public void testStaffCreation()
    {

        Time startTime = new Time(12,00,00);
        Time endTime = new Time(19,00,00);
        Date start = new Date(2013,10,13);
        Date end = new Date(2016,10,13);
        Employee employee = employeeFactory.createEmployee((long) 2323, "gavin", "ackerman", 23, "England");
        List<Employee>employees = new ArrayList<Employee>();
        employees.add(employee);
        Staff staff = factory.createStaff((long) 2323,start, startTime, endTime,employees);
        Assert.assertEquals(start, staff.getDay());
    }


    public void testStaffCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Time endTime = new Time(19,00,00);
        Date start = new Date(2013,10,13);
        Date end = new Date(2016,10,13);
        Employee employee = employeeFactory.createEmployee((long) 2323, "gavin", "ackerman", 23, "England");
        List<Employee>employees = new ArrayList<Employee>();
        employees.add(employee);
        Staff staff = factory.createStaff((long) 2323,start, startTime, endTime,employees);
        Time newTime = new Time(02,00,00);
        Staff upodateStaff = new Staff.Builder(staff.getId())
                .copy(staff)
                .startTime(newTime)
                .build();

        Assert.assertEquals(newTime, upodateStaff.getStartTime());

    }
}
