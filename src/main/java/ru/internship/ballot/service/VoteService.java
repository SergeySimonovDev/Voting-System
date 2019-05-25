package ru.internship.ballot.service;

import ru.internship.ballot.model.Vote;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VoteService {

    Vote create(int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId);

    Vote getTodayVote(int userId);

}
