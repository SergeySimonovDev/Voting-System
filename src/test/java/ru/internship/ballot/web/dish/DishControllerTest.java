package ru.internship.ballot.web.dish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.web.AbstractControllerTest;
import ru.internship.ballot.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.TestUtil.readFromJsonResultActions;
import static ru.internship.ballot.TestUtil.userHttpBasic;
import static ru.internship.ballot.UserTestData.ADMIN;

public class DishControllerTest extends AbstractControllerTest {

 /*   private static String REST_URL = DishRestController.REST_URL + '/';

    @Autowired
    private DishService service;

    private String replaceRestaurantIdToRestURL(int restaurant_id) {
        return REST_URL.replace("{restaurantId}", String.valueOf(restaurant_id));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(replaceRestaurantIdToRestURL(RESTAURANT1_ID))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getDishMatcher(DISH4, DISH3, DISH1, DISH2));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(replaceRestaurantIdToRestURL(RESTAURANT1_ID) + DISH1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getDishMatcher(DISH1));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(replaceRestaurantIdToRestURL(RESTAURANT1_ID) + 1)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testCreate() throws Exception {
        Dish created = getCreated();
        ResultActions action = mockMvc.perform(post(replaceRestaurantIdToRestURL(RESTAURANT1_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))
                .with(userHttpBasic(ADMIN)));

        Dish returned = readFromJsonResultActions(action, Dish.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
        assertMatch(service.getAll(RESTAURANT1_ID), DISH4, DISH3, created, DISH1, DISH2);
    }

    @Test
    public void testUpdate() throws Exception {
        Dish updated = getUpdated();

        mockMvc.perform(put(replaceRestaurantIdToRestURL(RESTAURANT1_ID) + DISH1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());

        assertMatch(service.get(DISH1_ID, RESTAURANT1_ID), updated);
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(replaceRestaurantIdToRestURL(RESTAURANT1_ID) + DISH1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());
        assertMatch(service.getAll(RESTAURANT1_ID), DISH4, DISH3, DISH2);
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(replaceRestaurantIdToRestURL(RESTAURANT1_ID) + 1)
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }*/
}