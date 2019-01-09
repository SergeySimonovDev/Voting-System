package ru.internship.ballot.repository.datajpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.internship.ballot.model.Restaurant;
import ru.internship.ballot.repository.RestaurantRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudRestaurantRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static final Sort SORT_TITLE = new Sort(Sort.Direction.ASC, "title");

    @Autowired
    CrudRestaurantRepository crudRestaurantRepository;

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll(SORT_TITLE);
    }

    @Override
    public Optional<Restaurant> get(int id) {
        return crudRestaurantRepository.findById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }




}
