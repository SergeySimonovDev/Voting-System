package ru.internship.ballot.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.internship.ballot.DishTestData;
import ru.internship.ballot.RestaurantTestData;
import ru.internship.ballot.model.Restaurant;
import ru.internship.ballot.service.RestaurantService;
import ru.internship.ballot.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.RestaurantTestData.*;
import static ru.internship.ballot.RestaurantTestData.assertMatch;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class RestaurantServiceImplTest {

    @Autowired
    private RestaurantService service;

    @Test
    void create() {
        Restaurant created = RestaurantTestData.getCreated();
        service.create(created);
        assertMatch(service.getAll(), created, FIRST_RESTAURANT, SECOND_RESTAURANT);
    }

    @Test
    void duplicate() {
        Restaurant duplicate = RestaurantTestData.getDuplicate();
        assertThrows(DataAccessException.class, () ->
                service.create(duplicate));
    }

    @Test
    void update() {
        Restaurant updated = RestaurantTestData.getUpdated();
        service.update(updated);
        assertMatch(service.getAll(), SECOND_RESTAURANT, updated);
    }

    @Test
    void delete() {
        service.delete(FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(), SECOND_RESTAURANT);
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(3));
    }

    @Test
    void get() {
        Restaurant restaurant = service.get(FIRST_RESTAURANT_ID);
        assertMatch(restaurant, FIRST_RESTAURANT);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(3));
    }

    @Test
    void getAll() {
        assertMatch(service.getAll(), FIRST_RESTAURANT, SECOND_RESTAURANT);
    }

    @Test
    void getWithDishes() {
        Restaurant restaurant = service.getWithDishes(FIRST_RESTAURANT_ID);
        DishTestData.assertMatch(restaurant.getDishes(), DISH6, DISH5, DISH3, DISH4);
    }

    @Test
    void getWithDishesNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.getWithDishes(3));
    }
}