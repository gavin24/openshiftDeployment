package za.cput.gavin.zoo.RepositoryTests;

import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.cput.gavin.zoo.App;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Repository.EmployeeRepository;

import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeRepoTest extends AbstractTestNGSpringContextTests {
    private static final String TAG="Employee TEST";
    private Long id;
    @Autowired
   private EmployeeRepository repo;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {

        // CREATE
        Employee createEntity = new Employee.Builder()
                .name("Alec")
                .surname("Jamwwesfgg21fdhdf")
                .age(34)
                .Country("SA")
                .password("w32f3552d2")
                .email("bla1wh12@gmail.com")
                .build();
        Employee insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

      /*  //READ ALL
        Iterable<Employee> settings = repo.findAll();
     //   Assert.assertTrue(TAG+" READ ALL",settings.()>0);

        //READ ENTITY
        Employee entity = repo.findOne(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);*/


/*
        //UPDATE ENTITY
        Employee updateEntity = new Employee.Builder()

                .copy(entity)
                .name("Petery")
                .surname("alex")
                .build();
        repo.update(updateEntity);
        Employee newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Peter", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Employee deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);*/

    }
}
