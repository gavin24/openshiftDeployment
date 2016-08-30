package za.cput.gavin.zoo.services;

import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Food;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public interface EmployeeService extends Service<Employee,Long> {
    Employee addEmployee(Employee employee);
    boolean isAuthentic(String userName,String Password);
}
