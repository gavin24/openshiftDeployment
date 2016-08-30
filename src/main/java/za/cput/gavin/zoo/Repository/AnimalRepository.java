package za.cput.gavin.zoo.Repository;

import za.cput.gavin.zoo.Domain.Animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.cput.gavin.zoo.Domain.Animal;

/**
 * Created by gavin.ackerman on 2016-04-23.
 */
@Repository
public interface AnimalRepository extends CrudRepository<Animal,Long>{
}
