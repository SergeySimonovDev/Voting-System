package ru.internship.ballot.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.RestaurantTestData.FIRST_RESTAURANT_ID;
import static ru.internship.ballot.RestaurantTestData.SECOND_RESTAURANT_ID;

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
    void testCreate() {
        Dish created = getCreated();
        service.create(created, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH1, created, DISH3, DISH4);
    }

    @Test
    void testUpdate() {
        Dish updated = getUpdated();
        service.update(updated, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH3, DISH4, updated);
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> service.update(DISH1, SECOND_RESTAURANT_ID));
    }


    @Test
    void testDelete() {
        service.delete(DISH1_ID, FIRST_RESTAURANT_ID);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH3, DISH4);
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(DISH1_ID, 3));
    }

    @Test
    void testGet() {
        Dish dish = service.get(DISH1_ID, FIRST_RESTAURANT_ID);
        assertMatch(dish, DISH1);
    }

    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(DISH1_ID, SECOND_RESTAURANT_ID));
    }

    @Test
    void testGetAll() {
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH1, DISH3, DISH4);
    }

    @Test
    void testGetMenu() {
        assertMatch(service.getMenu(FIRST_RESTAURANT_ID), DISH6, DISH5, DISH3, DISH4);
    }
}