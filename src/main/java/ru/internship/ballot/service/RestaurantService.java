package ru.internship.ballot.service;

import ru.internship.ballot.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    void update(Restaurant restaurant);

    void delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    Restaurant getWithDishes(int id);
}
