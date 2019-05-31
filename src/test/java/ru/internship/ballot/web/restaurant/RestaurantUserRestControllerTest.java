package ru.internship.ballot.web.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.internship.ballot.service.RestaurantService;
import ru.internship.ballot.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.internship.ballot.RestaurantTestData.*;
import static ru.internship.ballot.TestUtil.userHttpBasic;
import static ru.internship.ballot.UserTestData.ADMIN;
import static ru.internship.ballot.UserTestData.USER1;

class RestaurantUserRestControllerTest extends AbstractControllerTest {

    private static String REST_URL = RestaurantUserRestController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

    @Test
    void getRestaurant() throws Exception {
        mockMvc.perform(get(REST_URL + FIRST_RESTAURANT_ID)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getRestaurantMatcher(FIRST_RESTAURANT));
    }

    @Test
    void getAllRestaurants() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getRestaurantMatcher(FIRST_RESTAURANT, SECOND_RESTAURANT));
    }
}