package ru.internship.ballot.web.dish;

import org.junit.jupiter.api.Test;
import ru.internship.ballot.DishTestData;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.web.AbstractControllerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.internship.ballot.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.internship.ballot.RestaurantTestData.*;
import static ru.internship.ballot.TestUtil.readFromJsonResultActions;
import static ru.internship.ballot.UserTestData.*;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.TestUtil.userHttpBasic;

class DishRestControllerTest extends AbstractControllerTest {

    private static String REST_URL = DishRestController.REST_URL + '/';

    @Autowired
    private DishService service;

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL, FIRST_RESTAURANT_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getDishMatcher(DISH6, DISH2, DISH5, DISH1, DISH3, DISH4));
    }

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + DISH1_ID, FIRST_RESTAURANT_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getDishMatcher(DISH1));
    }

    @Test
    void testCreate() throws Exception {
        Dish created = DishTestData.getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL, FIRST_RESTAURANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))
                .with(userHttpBasic(ADMIN)));

        Dish returned = readFromJsonResultActions(action, Dish.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH1, created, DISH3, DISH4);
    }

    @Test
    void testUpdate() throws Exception {
        Dish updated = DishTestData.getUpdated();

        mockMvc.perform(put(REST_URL + DISH1_ID, FIRST_RESTAURANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());

        assertMatch(service.get(DISH1_ID, FIRST_RESTAURANT_ID), updated);
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + DISH1_ID, FIRST_RESTAURANT_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());
        assertMatch(service.getAll(FIRST_RESTAURANT_ID), DISH6, DISH2, DISH5, DISH3, DISH4);
    }
}