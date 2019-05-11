package ru.internship.ballot.service;

import ru.internship.ballot.model.Vote;
import java.time.LocalDate;
import java.util.Optional;

public interface VoteService {

    Vote create(int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId);

    Optional<Vote> getTodayVote(int userId, LocalDate todayDate);

}
