package ru.internship.ballot.repository;

import ru.internship.ballot.model.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> getByEmail(String email);

    Optional<User> get(int id);

    Optional<User> getByEmailWithVotes(String email);

}
