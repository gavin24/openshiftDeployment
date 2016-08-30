package za.cput.gavin.zoo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.cput.gavin.zoo.Domain.Animal;
import za.cput.gavin.zoo.services.AnimalService;

import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-08-19.
 */
@RestController
public class AnimalController {
    // Inject Service
    @Autowired
    private AnimalService animalService;

    //-------------------Create a Animal--------------------------------------------------------

    @RequestMapping(value = "/animal/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAnimal(@RequestBody Animal animal, UriComponentsBuilder ucBuilder) {
        animalService.create(animal);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Animal--------------------------------------------------------
    @RequestMapping(value = "/animal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") long id) {
        Animal animal = animalService.readById(id);
        if (animal == null) {
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }


    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/animals/", method = RequestMethod.GET)
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> patients = animalService.readAll();
        if(patients.isEmpty())
            return new ResponseEntity<List<Animal>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        return new ResponseEntity<List<Animal>>(patients, HttpStatus.OK);
    }

    //------------------- Update a Animal --------------------------------------------------------

    @RequestMapping(value = "/animal/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") long id, @RequestBody Animal animal) {

        Animal currentAnimal = animalService.readById(id);

        if (currentAnimal==null) {
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }

        Animal updatedAnimal= new Animal.Builder()

                .copy(currentAnimal)
                .Country(animal.getCountry())
                .name(animal.getName())
                .age(animal.getAge())
                .species(animal.getSpecies())
                .build();
        animalService.update(updatedAnimal);
        return new ResponseEntity<Animal>(updatedAnimal, HttpStatus.OK);
    }

    //------------------- Delete a Animal --------------------------------------------------------

    @RequestMapping(value = "/animal/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Animal> deleteAnimal(@PathVariable("id") long id) {
        Animal animal = animalService.readById(id);
        if (animal == null) {
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
        animalService.delete(animal);
        return new ResponseEntity<Animal>(HttpStatus.NO_CONTENT);
    }
}
