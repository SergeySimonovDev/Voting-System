package ru.internship.ballot.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.internship.ballot.RestaurantTestData;
import ru.internship.ballot.UserTestData;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.repository.VoteRepository;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.util.ValidationUtil;
import ru.internship.ballot.util.exception.VotingTimeIsOverException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.internship.ballot.VoteTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class VoteServiceImplTest {

    @Autowired
    private VoteService service;
    // gives additional functionality for testing
    @Autowired
    private VoteRepository repository;

    @BeforeEach
    void setUp() {
        ValidationUtil.setDefaultDeadLine();
    }

    @Test
    void testCreate() {
        service.create(UserTestData.USER1_ID, RestaurantTestData.FIRST_RESTAURANT_ID);
        assertMatch(service.getTodayVote(UserTestData.USER1_ID), TODAYVOTE_USER1);
    }

    @Test
    void testUpdate() {
        ValidationUtil.setUnreachableDeadLine();
        Vote updated = getUpdated();
        service.update(updated, UserTestData.USER1_ID, RestaurantTestData.SECOND_RESTAURANT_ID);
        assertMatch(repository.findAll(), updated, VOTE1_USER2, VOTE2_USER1, VOTE2_USER2);
    }

    @Test
    void testUpdateDeadLineTime() {
        ValidationUtil.setAbsoluteDeadLine();
        Vote updated = getUpdated();
        assertThrows(VotingTimeIsOverException.class,
                () -> service.update(updated, UserTestData.USER1_ID, RestaurantTestData.SECOND_RESTAURANT_ID));
    }
}