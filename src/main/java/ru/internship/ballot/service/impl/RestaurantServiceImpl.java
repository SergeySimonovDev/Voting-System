package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Restaurant;
import ru.internship.ballot.repository.RestaurantRepository;
import ru.internship.ballot.service.RestaurantService;
import ru.internship.ballot.util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

import static ru.internship.ballot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        Optional.of(repository.save(restaurant)).orElseThrow(() -> new NotFoundException("id=" + restaurant.getId()));
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Restaurant get(int id) {
        return repository.get(id).orElseThrow(() -> new NotFoundException("id= " + id));
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
