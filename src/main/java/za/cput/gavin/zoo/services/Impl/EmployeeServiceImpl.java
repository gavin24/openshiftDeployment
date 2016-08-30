package za.cput.gavin.zoo.services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Repository.EmployeeRepository;

import za.cput.gavin.zoo.services.EmployeeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
     EmployeeRepository repository;

/*    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private static EmployeeServiceImpl service = null;

    public static EmployeeServiceImpl getInstance()
    {
        if(service == null)
            service = new EmployeeServiceImpl();
        return service;
    }

    public EmployeeServiceImpl()
    {
        repository = new EmployeeRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public EmployeeServiceImpl getService() {
            return EmployeeServiceImpl.this;
        }
    }*/
    public boolean isAuthentic(String username,String password)
    {
        Iterable<Employee> employees;
        employees = repository.findAll();

        for (Employee employee : employees)

        {
            if (employee.getEmail().equalsIgnoreCase(username) && employee.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        try{
            return repository.save(employee);
        }
        catch(Exception x)

        {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public Employee create(Employee employee) {
        try{
            return repository.save(employee);
        }
        catch(Exception x)

        {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public void delete(Employee employee) {
         repository.delete(employee);
    }


    @Override
    public List<Employee> readAll() {
        List<Employee> allPatients = new ArrayList<Employee>();
        Iterable<Employee> patients = repository.findAll();
        for (Employee patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee readById(Long Id) {
        return repository.findOne(Id);
    }
}
