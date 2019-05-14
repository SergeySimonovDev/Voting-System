package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.repository.DishRepository;
import ru.internship.ballot.repository.RestaurantRepository;
import ru.internship.ballot.service.DishService;

import java.util.List;
import java.util.Optional;

import static ru.internship.ballot.util.ValidationUtil.checkNotFoundWithId;

@Service("dishService")
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        if (!dish.isNew() && get(dish.getId(), restaurantId) == null) {
            return null;
        }
        else {
            dish.setRestaurant(restaurantRepository.getOne(restaurantId));
        }
        return dishRepository.save(dish);
    }

    @Override
    public void update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(create(dish, restaurantId), dish.getId());
    }

    @Override
    public void delete(int id, int restaurantId) {
        checkNotFoundWithId(dishRepository.delete(id, restaurantId), id);
    }

    @Override
    public Dish get(int id, int restaurantId) {
        Optional<Dish> dish = dishRepository.get(id, restaurantId);
        return checkNotFoundWithId(dish.isPresent() && dish.get().getId() == restaurantId ? dish.get() : null, id);
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return dishRepository.getAllByRestaurant(restaurantId);
    }
}
