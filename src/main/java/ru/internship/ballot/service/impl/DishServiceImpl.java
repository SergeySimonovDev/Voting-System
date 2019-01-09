package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.repository.DishRepository;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

import static ru.internship.ballot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository repository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        return repository.save(dish, restaurantId);
    }

    @Override
    public void update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        Optional.of(repository.save(dish, restaurantId)).orElseThrow(() -> new NotFoundException("id= " + dish.getId()));
    }

    @Override
    public void delete(int id, int restaurantId) {
        checkNotFoundWithId(repository.delete(id, restaurantId), id);
    }

    @Override
    public Dish get(int id, int restaurantId) {
        return repository.get(id, restaurantId).orElseThrow(() -> new NotFoundException("id= " + id));
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }
}
