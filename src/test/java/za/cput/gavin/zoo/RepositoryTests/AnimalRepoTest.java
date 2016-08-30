package za.cput.gavin.zoo.RepositoryTests;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.cput.gavin.zoo.App;
import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Repository.AnimalRepository;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
/**
 * Created by gavin.ackerman on 2016-08-21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AnimalRepoTest extends AbstractTestNGSpringContextTests {
    private static final String TAG="Animal TEST";
    private Long id;
    @Autowired
    private AnimalRepository repo ;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {

        // CREATE

        Animal createEntity = new Animal.Builder()
                .name("Johny")
                .species("bear")
                .age(24)
                .Country("england")
                       // .food(food)
                .build();

        Animal insertedEntity = repo.save(createEntity);
        //    Animal insertedEntity2 = repo.save(createEntity2);
        //  Animal insertedEntity3 = repo.save(createEntity3);

        id=insertedEntity.getId();
        Assert.assertNotNull( insertedEntity);

      /*  //READ ALL
        Set<Animal> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Animal entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Animal updateEntity = new Animal.Builder()
                .id(entity.getId())
                .copy(entity)
                .Country("USA")
                .build();
        repo.update(updateEntity);
        Animal newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","USA",newEntity.getCountry());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Animal deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
*/
    }
}
