package ru.internship.ballot.util;

import ru.internship.ballot.model.Role;
import ru.internship.ballot.model.User;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.to.UserTo;

import java.time.LocalDate;
import java.util.Optional;


public class UserUtil {

    public static User createNewFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static Optional<Vote> getTodayVote(User user) {
        return user.getVotes().stream().filter(v -> v.getDate().isEqual(LocalDate.now())).findFirst();
    }

}