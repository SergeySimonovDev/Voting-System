package ru.internship.ballot.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.internship.ballot.service.UserService;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.util.ValidationUtil;
import ru.internship.ballot.web.AbstractControllerTest;

import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.internship.ballot.DishTestData.*;
import static ru.internship.ballot.RestaurantTestData.*;
import static ru.internship.ballot.TestUtil.userHttpBasic;
import static ru.internship.ballot.UserTestData.USER1;
import static ru.internship.ballot.UserTestData.USER1_ID;
import static ru.internship.ballot.VoteTestData.assertMatch;
import static ru.internship.ballot.VoteTestData.*;

public class UserRestaurantControllerTest extends AbstractControllerTest {
/*
    private static final String REST_URL = UserRestaurantController.REST_URL + '/';
    private static final String DISHES_PART_URL = "/dishes";
    private static final String VOTE_PART_URL = "/vote";

    @Autowired
    private UserService userService;
    @Autowired
    private VoteService voteService;

    @Test
    public void testGetAllRestaurants() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getRestaurantMatcher(FIRST_RESTAURANT, SECOND_RESTAURANT));
    }

    @Test
    public void testGetAllDishesByRestaurant() throws Exception {
        mockMvc.perform(get(REST_URL + FIRST_RESTAURANT_ID + DISHES_PART_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(getDishMatcher(DISH4_FIRST_RESTAURANT, DISH3_FIRST_RESTAURANT, DISH1_FIRST_RESTAURANT, DISH2_FIRST_RESTAURANT));
    }

    @Test
    public void doVote() throws Exception {

        ValidationUtil.setDeadlineTime(LocalTime.now().plusHours(1));

        mockMvc.perform(get(REST_URL + FIRST_RESTAURANT_ID + VOTE_PART_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isNoContent());

        assertMatch(voteService.getByUser(USER1_ID), VOTE1_USER1, VOTE2_USER1, VOTE3_USER1);

    }

    @Test
    public void doVoteTimeIsOver() throws Exception {
        ValidationUtil.setDeadlineTime(LocalTime.of(0, 0));

        mockMvc.perform(get(REST_URL + FIRST_RESTAURANT_ID + VOTE_PART_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isNotAcceptable())
                .andDo(print());
    }*/
}