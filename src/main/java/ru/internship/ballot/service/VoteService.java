package ru.internship.ballot.service;

import ru.internship.ballot.model.Vote;

public interface VoteService {

    Vote create(int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId);

    Vote getTodayVote(int userId);

}
