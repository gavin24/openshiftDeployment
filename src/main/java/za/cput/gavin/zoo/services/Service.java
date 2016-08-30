package za.cput.gavin.zoo.services;

import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-15.
 */
public interface Service<E, ID> {

    E readById(ID id);

    E create(E entity);

    E update(E entity);

    void delete(E entity);

    public List<E> readAll();

    void deleteAll();
}
