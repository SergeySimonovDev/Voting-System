package ru.internship.ballot;

import ru.internship.ballot.model.Role;
import ru.internship.ballot.model.User;

import static ru.internship.ballot.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER1_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 3;

    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static final User USER1 = new User(USER1_ID, "TestUser1", "user1@yandex.ru", "password", Role.ROLE_USER);


}
