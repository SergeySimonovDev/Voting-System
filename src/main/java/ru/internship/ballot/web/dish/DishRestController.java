package ru.internship.ballot.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.service.DishService;

import java.util.List;

import static ru.internship.ballot.util.ValidationUtil.assureIdConsistent;
import static ru.internship.ballot.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {

    static final String REST_URL = "/rest/admin/restaurants/{restaurantId}/dishes";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll(@PathVariable("restaurantId") int restaurantId) {
        log.info("get all dishes for restaurant {}", restaurantId);
        return service.getAll(restaurantId);
    }

    @GetMapping(value = "/{dishId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("restaurantId") int restaurantId, @PathVariable("dishId") int id) {
        log.info("get dish {} for restaurant {}", id, restaurantId);
        return service.get(id, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Dish create(@RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId) {
        checkNew(dish);
        log.info("create dish {} for restaurant {}", dish, restaurantId);
        return service.create(dish, restaurantId);
    }

    @PutMapping(value = "/{dishId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId, @PathVariable("dishId") int id) {
        assureIdConsistent(dish, id);
        log.info("update dish {} for restaurant {}", dish, restaurantId);
        service.update(dish, restaurantId);
    }

    @DeleteMapping(value = "/{dishId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurantId") int restaurantId, @PathVariable("dishId") int id) {
        log.info("delete dish {} for restaurant {}", id, restaurantId);
        service.delete(id, restaurantId);
    }

}
