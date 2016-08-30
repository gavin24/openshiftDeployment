package za.cput.gavin.zoo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.cput.gavin.zoo.Domain.Employee;
import za.cput.gavin.zoo.Domain.Food;
import za.cput.gavin.zoo.services.FoodService;

import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-19.
 */
@RestController
public class FoodController {
    // Inject Service
    @Autowired
    private FoodService foodService;

    //-------------------Create a Food--------------------------------------------------------

    @RequestMapping(value = "/food/", method = RequestMethod.POST)
    public ResponseEntity<Void> createFood(@RequestBody Food food, UriComponentsBuilder ucBuilder) {
        foodService.create(food);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/food/{id}").buildAndExpand(food.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Food--------------------------------------------------------
    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> getFood(@PathVariable("id") long id) {
        Food food = foodService.readById(id);
        if (food == null) {
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }


    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/foods/", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> getFoods() {
        List<Food> patients = foodService.readAll();
        if(patients.isEmpty())
            return new ResponseEntity<List<Food>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        return new ResponseEntity<List<Food>>(patients, HttpStatus.OK);
    }

    //------------------- Update a Food --------------------------------------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Food> updateFood(@PathVariable("id") long id, @RequestBody Food food) {

        Food currentFood = foodService.readById(id);

        if (currentFood==null) {
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        Food updatedFood = new Food.Builder()

                .copy(currentFood)
                .name("beef")
                .build();
        foodService.update(updatedFood);
        return new ResponseEntity<Food>(updatedFood, HttpStatus.OK);
    }

    //------------------- Delete a Food --------------------------------------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Food> deleteFood(@PathVariable("id") long id) {
        Food food = foodService.readById(id);
        if (food == null) {
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        foodService.delete(food);
        return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);
    }
}
