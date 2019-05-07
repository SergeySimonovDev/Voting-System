package ru.internship.ballot;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.internship.ballot.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.internship.ballot.TestUtil.readFromJsonMvcResult;
import static ru.internship.ballot.TestUtil.readListFromJsonMvcResult;
import static ru.internship.ballot.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT1_ID = START_SEQ + 3;
    public static final int RESTAURANT2_ID = START_SEQ + 4;

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "Starbucks", "Spb, Tulskay ul, d.96");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT2_ID, "Tokyo City", "Spb, pr. Tvorskogo, d.11");

    public static Restaurant getCreated() {
        return new Restaurant(null, "New restaurant", "Spb, ul. nothing, d. 0");
    }

    public static Restaurant getDuplicate() {
        return new Restaurant(null, "Starbucks", "Spb, Tulskay ul, d.96");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "Updated restaurant", RESTAURANT1.getAddress());
    }

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "dishes", "votes");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("dishes", "votes").isEqualTo(expected);
    }

    public static ResultMatcher getRestaurantMatcher(Restaurant... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, Restaurant.class), List.of(expected));
    }

    public static ResultMatcher getRestaurantMatcher(Restaurant expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, Restaurant.class), expected);
    }
}
