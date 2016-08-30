package za.cput.gavin.zoo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.services.EmployeeService;

import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-19.
 */
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //-------------------Create a Employee--------------------------------------------------------

    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
        employeeService.create(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Employee--------------------------------------------------------
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.readById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/employees/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> patients = employeeService.readAll();
        if(patients.isEmpty())
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        return new ResponseEntity<List<Employee>>(patients, HttpStatus.OK);
    }

    //------------------- Update a Employee --------------------------------------------------------

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {

        Employee currentEmployee = employeeService.readById(id);

        if (currentEmployee==null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        Employee updatedEmployee = new Employee.Builder()

                .copy(currentEmployee)
                .name(employee.getName())
                .surname(employee.getsurname())
                .build();

        employeeService.update(updatedEmployee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    //------------------- Delete a Employee --------------------------------------------------------

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.readById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
