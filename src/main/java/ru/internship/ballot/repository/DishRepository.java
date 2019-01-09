package ru.internship.ballot.repository;

import ru.internship.ballot.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {

    Dish save(Dish dish, int restaurantId);

    boolean delete(int id, int restaurantId);

    Optional<Dish> get(int id, int restaurantId);

    List<Dish> getAll(int restaurantId);

}
