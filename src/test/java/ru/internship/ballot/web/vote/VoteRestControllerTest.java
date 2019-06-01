package ru.internship.ballot.web.vote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.internship.ballot.VoteTestData;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.repository.VoteRepository;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.util.ValidationUtil;
import ru.internship.ballot.web.AbstractControllerTest;
import ru.internship.ballot.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.internship.ballot.RestaurantTestData.*;
import static ru.internship.ballot.TestUtil.userHttpBasic;
import static ru.internship.ballot.UserTestData.USER1;
import static ru.internship.ballot.VoteTestData.*;

class VoteRestControllerTest extends AbstractControllerTest {

    private static String REST_URL = VoteRestController.REST_URL + '/';

    @Autowired
    private VoteService service;
    // gives additional functionality for testing
    @Autowired
    private VoteRepository repository;

    @BeforeEach
    void setDefaultDeadLine() {
        ValidationUtil.setDefaultDeadLine();
    }

    @Test
    void testVote() throws Exception {
        mockMvc.perform(get(REST_URL + FIRST_RESTAURANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER1))
                .content(JsonUtil.writeValue(FIRST_RESTAURANT_ID)))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertMatch(repository.findAll(), VOTE1_USER1, VOTE1_USER2, VOTE2_USER1, VOTE2_USER2, TODAYVOTE_USER1);
    }

    @Test
    void testReVote() throws Exception {

        // create vote today
        testVote();

        ValidationUtil.setUnreachableDeadLine();

        Vote updated = VoteTestData.getNextVote();
        updated.setRestaurant(SECOND_RESTAURANT);

        mockMvc.perform(get(REST_URL + SECOND_RESTAURANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER1))
                .content(JsonUtil.writeValue(SECOND_RESTAURANT_ID)))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertMatch(repository.findAll(), VOTE1_USER1, VOTE1_USER2, VOTE2_USER1, VOTE2_USER2, updated);
    }

    @Test
    void testReVoteAfterDeadLine() throws Exception {

        // create vote today
        testVote();

        ValidationUtil.setAbsoluteDeadLine();

        mockMvc.perform(get(REST_URL + SECOND_RESTAURANT_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER1))
                .content(JsonUtil.writeValue(FIRST_RESTAURANT_ID)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}