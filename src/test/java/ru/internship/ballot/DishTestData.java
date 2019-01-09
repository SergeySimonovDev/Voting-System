package ru.internship.ballot;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.internship.ballot.model.Dish;

import java.time.Month;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.internship.ballot.TestUtil.readFromJsonMvcResult;
import static ru.internship.ballot.TestUtil.readListFromJsonMvcResult;
import static ru.internship.ballot.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static final int DISH1_ID = START_SEQ + 5;

    public static final Dish DISH2 = new Dish(DISH1_ID + 1, "Tomato soup", 150, of(2018, Month.DECEMBER, 4, 6, 0));
    public static final Dish DISH1 = new Dish(DISH1_ID, "Steak", 350, of(2018, Month.DECEMBER, 4, 6, 0));
    public static final Dish DISH3 = new Dish(DISH1_ID + 2, "Espresso", 100, of(2018, Month.DECEMBER, 4, 6, 0));
    public static final Dish DISH4 = new Dish(DISH1_ID + 3, "Cheese Toast", 110, of(2018, Month.DECEMBER, 4, 6, 0));

    public static Dish getCreated() {
        return new Dish(null, "New dish", 330, of(2018, Month.DECEMBER, 5, 10, 0));
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "Updated dish", 200, DISH1.getDateTime());
    }

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant").isEqualTo(expected);
    }

    public static ResultMatcher getDishMatcher(Dish... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, Dish.class), List.of(expected));
    }

    public static ResultMatcher getDishMatcher(Dish expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, Dish.class), expected);
    }
}