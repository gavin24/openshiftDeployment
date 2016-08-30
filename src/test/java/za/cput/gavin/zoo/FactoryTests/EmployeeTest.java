package za.cput.gavin.zoo.FactoryTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Factories.Impl.EmployeeFactoryImpl;
import za.cput.gavin.zoo.Factories.EmployeeFactory;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-05.
 */
public class EmployeeTest extends TestCase {
    private EmployeeFactory factory;


    public void setUp() throws Exception{
        factory = EmployeeFactoryImpl.getInstance();
    }


    public void testEmployeeCreation()
    {
        Date start = new Date(2013,10,13);
        Employee employee = factory.createEmployee((long) 2323, "John", "Peters", 23,"South Africa");
        Assert.assertEquals(23, employee.getAge());
    }


    public void testEmployeeCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Employee employee = factory.createEmployee((long) 2323, "John", "Peters", 23,"South Africa");
        Assert.assertEquals(23, employee.getAge());

        Employee upodateEmployee = new Employee.Builder(employee.getId())
                .copy(employee)
                .name("bruce")
                .build();

        Assert.assertEquals("bruce", upodateEmployee.getName());

    }
}
