package ru.internship.ballot.service;

import ru.internship.ballot.model.Vote;

import java.util.List;

public interface VoteService {

    Vote create(Vote vote, int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId);

   // List<Vote> getByUser(int userId);

   // Vote get(int id, int userId);

}
