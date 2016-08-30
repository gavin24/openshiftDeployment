package za.cput.gavin.zoo.Repository;

import za.cput.gavin.zoo.Domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by gavin.ackerman on 2016-04-23.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
}
