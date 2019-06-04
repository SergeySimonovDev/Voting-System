package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Restaurant;
import ru.internship.ballot.repository.RestaurantRepository;
import ru.internship.ballot.service.RestaurantService;

import java.util.List;

import static ru.internship.ballot.util.ValidationUtil.checkNotFoundWithId;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    @Override
    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }

    @Override
    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id) != 0, id);
    }

    @Override
    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.findById(id), id);
    }

    @Override
    @Cacheable("restaurants")
    public List<Restaurant> getAll() {
        return restaurantRepository.getAllByOrderByTitle();
    }

    @Override
    public Restaurant getWithDishes(int id) {
        return checkNotFoundWithId(restaurantRepository.getWithDishes(id), id);
    }

    @Override
    @CacheEvict(value = "restaurants", allEntries = true)
    public void evictCache() {}
}
