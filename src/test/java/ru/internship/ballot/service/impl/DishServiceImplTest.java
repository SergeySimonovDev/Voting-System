package ru.internship.ballot.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.internship.ballot.DishTestData;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.RestaurantTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class DishServiceImplTest {

    @Autowired
    private DishService service;

    @Test
    void create() {
        Dish created = DishTestData.getCreated();
        service.create(created, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH2, DISH1, created, DISH3, DISH4);
    }

    @Test
    void update() {
        Dish updated = DishTestData.getUpdated();
        service.update(updated, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), updated, DISH2, DISH3, DISH4);
    }

    @Test
    void updateNotFound(){
        assertThrows(NotFoundException.class, () -> service.update(DISH1, SECOND_RESTAURANT_ID));
    }


    @Test
    void delete() {
        service.delete(DISH1_ID, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH2, DISH3, DISH4);
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(DISH1_ID, 3));
    }

    @Test
    void get() {
        Dish dish = service.get(DISH1_ID, FIRST_RESTAURANT_ID);
        assertMatch(dish, DISH1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(DISH1_ID, SECOND_RESTAURANT_ID));
    }

    @Test
    void getAll() {
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH2, DISH1, DISH3, DISH4);
    }
}