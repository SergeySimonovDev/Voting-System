package ru.internship.ballot.repository.datajpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.internship.ballot.model.User;
import ru.internship.ballot.repository.UserRepository;
import ru.internship.ballot.repository.datajpa.crud.CrudUserRepository;

import java.util.Optional;
/*
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    CrudUserRepository crudUserRepository;

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return crudUserRepository.getByEmail(email);
    }

    @Override
    public Optional<User> get(int id) {
        return crudUserRepository.findById(id);
    }

    @Override
    public Optional<User> getByEmailWithVotes(String email) {
        return crudUserRepository.getByEmailWithVotes(email);
    }
}
*/