package ru.internship.ballot.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() throws Exception {
        service.evictCache();
    }

    @Test
    void testCreate() {
        Restaurant created = RestaurantTestData.getCreated();
        service.create(created);
        assertMatch(service.getAll(), created, FIRST_RESTAURANT, SECOND_RESTAURANT);
    }

    @Test
    void testDuplicate() {
        Restaurant duplicate = RestaurantTestData.getDuplicate();
        assertThrows(DataAccessException.class, () ->
                service.create(duplicate));
    }

    @Test
    void testUpdate() {
        Restaurant updated = RestaurantTestData.getUpdated();
        service.update(updated);
        assertMatch(service.getAll(), SECOND_RESTAURANT, updated);
    }

    @Test
    void testDelete() {
        service.delete(FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(), SECOND_RESTAURANT);
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(3));
    }

    @Test
    void testGet() {
        Restaurant restaurant = service.get(FIRST_RESTAURANT_ID);
        assertMatch(restaurant, FIRST_RESTAURANT);
    }

    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(3));
    }

    @Test
    void testGetAll() {
        assertMatch(service.getAll(), FIRST_RESTAURANT, SECOND_RESTAURANT);
    }

    @Test
    void testGetWithDishes() {
        Restaurant restaurant = service.getWithDishes(FIRST_RESTAURANT_ID);
        DishTestData.assertMatch(restaurant.getDishes(), DISH6, DISH5, DISH3, DISH4);
    }

    @Test
    void testGetWithDishesNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.getWithDishes(3));
    }
}