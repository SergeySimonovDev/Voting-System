package ru.internship.ballot;

import ru.internship.ballot.model.Role;
import ru.internship.ballot.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.internship.ballot.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER1_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 2;

    public static final String EMAIL_USER1 = "user1@yandex.ru";

    public static final User USER1 = new User(USER1_ID, "TestUser1", "user1@yandex.ru", "password", Role.ROLE_USER);
    public static final User USER2 = new User(USER1_ID + 1, "TestUser2", "user2@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);

    public static User getCreated() {
        return new User(null, "New user", "user@nothing.com", "qwerty007", Role.ROLE_USER);
    }

    public static User getDuplicate() {
        return new User(null, "Duplicate user", "user1@yandex.ru", "qwerty007", Role.ROLE_USER);
    }

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "votes", "registered");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("votes", "registered").isEqualTo(expected);
    }

}
