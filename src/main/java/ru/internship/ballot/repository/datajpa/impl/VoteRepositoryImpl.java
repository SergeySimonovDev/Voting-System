package ru.internship.ballot.repository.datajpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.repository.VoteRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudRestaurantRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudUserRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudVoteRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    CrudVoteRepository crudVoteRepository;
    @Autowired
    CrudUserRepository crudUserRepository;
    @Autowired
    CrudRestaurantRepository crudRestaurantRepository;

    @Override
    @Transactional
    public Vote save(Vote vote, int userId, int restaurantId) {

        if (!vote.isNew() && !get(vote.getId(), userId).isPresent()) {
            return null;
        }

        vote.setUser(crudUserRepository.getOne(userId));
        vote.setRestaurant(crudRestaurantRepository.getOne(restaurantId));

        return crudVoteRepository.save(vote);
    }

    @Override
    public Optional<Vote> get(int id, int userId) {
        return crudVoteRepository.findById(id);
    }

    @Override
    public List<Vote> getByUser(int userId) {
        return crudVoteRepository.getAllByUserId(userId);
    }
}
