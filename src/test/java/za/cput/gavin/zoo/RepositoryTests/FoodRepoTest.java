package za.cput.gavin.zoo.RepositoryTests;

import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.cput.gavin.zoo.App;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Repository.FoodRepository;

import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class FoodRepoTest extends AbstractTestNGSpringContextTests {
    private static final String TAG="Food TEST";
    private Long id;
    @Autowired
    private FoodRepository repo;
    @Test
    public void testCreateReadUpdateDelete() throws Exception {

        // CREATE  price(price).name(name).type(type)
        Food createEntity = new Food.Builder()
                .name("beef")
                .type("Meat")
                .price(500)
                .stock(30)
                .build();
        Food insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull( insertedEntity);

     /*   //READ ALL
        Iterable<Food> settings = repo.findAll();
      //  Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Food entity = repo.findOne(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);*/



        //UPDATE ENTITY
      /*  Food updateEntity = new Food.Builder()
                .id(entity.getId())
                .copy(entity)
                .name("beef")
                .build();
        repo.update(updateEntity);
        Food newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","beef",newEntity.getname());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Food deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);*/

    }
}
