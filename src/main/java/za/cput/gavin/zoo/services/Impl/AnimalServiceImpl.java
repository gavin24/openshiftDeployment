package za.cput.gavin.zoo.services.Impl;




import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Repository.AnimalRepository;

import za.cput.gavin.zoo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
@Service
public class AnimalServiceImpl  implements AnimalService {
    @Autowired
    AnimalRepository repository;

   /* private final IBinder localBinder = new AnimalServiceLocalBinder();

    private static AnimalServiceImpl service = null;

    public static AnimalServiceImpl getInstance()
    {
        if(service == null)
            service = new AnimalServiceImpl();
        return service;
    }

    public AnimalServiceImpl()
    {
        repository = new AnimalRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class AnimalServiceLocalBinder extends Binder {
        public AnimalServiceImpl getService() {
            return AnimalServiceImpl.this;
        }
    }*/


    @Override
    public Animal create(Animal animal) {
        try{
            return repository.save(animal);
        }
        catch(Exception x)

       {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public void delete(Animal animal) {
        repository.delete(animal);
    }


    @Override
    public List<Animal> readAll() {
        List<Animal> allPatients = new ArrayList<Animal>();
        Iterable<Animal> patients = repository.findAll();
        for (Animal patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }
    @Override
    public void deleteAll() {
       repository.deleteAll();
    }
    @Override
    public Animal update(Animal animal) {
        return repository.save(animal);
    }

    @Override
    public Animal readById(Long Id) {
        return repository.findOne(Id);
    }
}
