package ru.internship.ballot;

import ru.internship.ballot.model.Vote;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.internship.ballot.RestaurantTestData.RESTAURANT1;
import static ru.internship.ballot.RestaurantTestData.RESTAURANT2;
import static ru.internship.ballot.UserTestData.USER1;
import static ru.internship.ballot.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {

    public static final int VOTE1_ID_USER1 = START_SEQ + 14;
    public static final int VOTE2_ID_USER1 = VOTE1_ID_USER1 + 2;
    public static final int VOTE3_ID_USER1 = VOTE1_ID_USER1 + 4;

    public static final Vote VOTE1_USER1 = new Vote(VOTE1_ID_USER1, of(2018, Month.DECEMBER, 3), USER1, RESTAURANT1);
    public static final Vote VOTE2_USER1 = new Vote(VOTE2_ID_USER1, of(2018, Month.DECEMBER, 4), USER1, RESTAURANT2);
    public static final Vote VOTE3_USER1 = new Vote(VOTE3_ID_USER1, LocalDate.now(), USER1, RESTAURANT1);

    public static void assertMatch(Vote actual, Vote expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields().isEqualTo(expected);
    }

}
