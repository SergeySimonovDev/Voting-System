package ru.internship.ballot.repository;

import ru.internship.ballot.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Optional<Restaurant> get(int id);

    List<Restaurant> getAll();

}
