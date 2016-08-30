package za.cput.gavin.zoo.services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.Repository.FoodRepository;

import za.cput.gavin.zoo.services.FoodService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
@Service
public class FoodServiceImpl  implements FoodService {
    @Autowired
    FoodRepository repository;

/*    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private static FoodServiceImpl service = null;

    public static FoodServiceImpl getInstance()
    {
        if(service == null)
            service = new FoodServiceImpl();
        return service;
    }

   public FoodServiceImpl()
    {
        repository = new FoodRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public FoodServiceImpl getService() {
            return FoodServiceImpl.this;
        }
    }*/
    @Override
    public Food addFood(Food food) {
        try{
            return repository.save(food);
        }
        catch(Exception x)

        {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public int addStock(int stock,Food food) {

            //Food found = repository.findById(food.getId());
            Food updatedFood = new Food.Builder()
                    .copy(food)
                   /* .id(found.getId())
                    .price(found.getprice())
                    .name(found.getname())*/
                   // .stock(found.getStock()+stock)
                    .stock(food.getStock()+stock)
                  //  .type(found.getType())
                    .build();
             repository.save(updatedFood);
            return updatedFood.getStock();

    }

    @Override
    public int removeStock(int stock,Food food) {

           // Food found = repository.findById(food.getId());
            Food updatedFood = new Food.Builder()
                    .copy(food)
                  /*  .id(found.getId())
                    .price(found.getprice())
                    .name(found.getname())*/
                    .stock(food.getStock()-stock)
                   // .type(found.getType())
                    .build();
            repository.save(updatedFood);
            return updatedFood.getStock();

    }
    @Override
    public Food create(Food food) {
        try{
            return repository.save(food);
        }
        catch(Exception x)

        {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public void delete(Food food) {
         repository.delete(food);
    }



    @Override
    public List<Food> readAll() {
        List<Food> allPatients = new ArrayList<Food>();
        Iterable<Food> patients = repository.findAll();
        for (Food patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
    @Override
    public Food update(Food food) {
        return repository.save(food);
    }

    @Override
    public Food readById(Long Id) {
        return repository.findOne(Id);
    }
}
