package ru.internship.ballot.repository.datajpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.repository.DishRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudDishRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudRestaurantRepository;

import java.util.List;
import java.util.Optional;
/*
@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    CrudDishRepository crudDishRepository;

    @Autowired
    CrudRestaurantRepository crudRestaurantRepository;

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && !get(dish.getId(), restaurantId).isPresent()) {
            return null;
        }
        dish.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return crudDishRepository.delete(id, restaurantId) != 0;
    }

    @Override
    public Optional<Dish> get(int id, int restaurantId) {
        return crudDishRepository.findById(id).filter(dish -> dish.getRestaurant().getId() == restaurantId);
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return crudDishRepository.getAll(restaurantId);
    }

}
*/