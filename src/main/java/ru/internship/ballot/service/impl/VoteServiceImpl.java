package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.repository.RestaurantRepository;
import ru.internship.ballot.repository.UserRepository;
import ru.internship.ballot.repository.VoteRepository;
import ru.internship.ballot.service.VoteService;
import java.time.LocalDate;

import static ru.internship.ballot.util.ValidationUtil.checkDeadLineTime;
import static ru.internship.ballot.util.ValidationUtil.checkNotFoundWithId;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Vote create(int userId, int restaurantId) {
        Vote vote = new Vote(LocalDate.now());
        vote.setUser(userRepository.getOne(userId));
        vote.setRestaurant(restaurantRepository.getOne(restaurantId));
        return voteRepository.save(vote);
    }

    @Override
    public Vote update(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        checkDeadLineTime();
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }

    @Override
    public Vote getTodayVote(int userId) {
        return voteRepository.getTodayVote(userId, LocalDate.now());
    }

}
