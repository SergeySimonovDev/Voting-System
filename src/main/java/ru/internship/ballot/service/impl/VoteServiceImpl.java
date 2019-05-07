package ru.internship.ballot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.repository.VoteRepository;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote create(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote, userId, restaurantId);
    }

    @Override
    public Vote update(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        return Optional.of(repository.save(vote, userId, restaurantId)).orElseThrow(() -> new NotFoundException("id=" + vote.getId()));
    }

    @Override
    public List<Vote> getByUser(int userId) {
        return repository.getByUser(userId);
    }

    @Override
    public Vote get(int id, int userId) {
        return repository.get(id, userId).orElseThrow(() -> new NotFoundException("id=" + id));
    }
}
