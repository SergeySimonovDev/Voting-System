package ru.internship.ballot.repository;

import ru.internship.ballot.model.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteRepository {

    Vote save(Vote meal, int userId, int restaurantId);

    Optional<Vote> get(int id, int userId);

    List<Vote> getByUser(int userId);

}
