package ru.internship.ballot.service;

import ru.internship.ballot.model.User;
import ru.internship.ballot.util.exception.NotFoundException;

public interface UserService {

    User create(User user);

    User getByEmail(String email) throws NotFoundException;

  //  User getByEmailWithVotes(String email) throws NotFoundException;

}
