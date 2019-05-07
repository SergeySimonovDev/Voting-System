package ru.internship.ballot.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.internship.ballot.model.Dish;
import ru.internship.ballot.model.Restaurant;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.service.DishService;
import ru.internship.ballot.service.RestaurantService;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.to.UserTo;
import ru.internship.ballot.web.SecurityUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static ru.internship.ballot.util.ValidationUtil.checkTimeIsOver;

@RestController
@RequestMapping(value = UserRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantController {
    static final String REST_URL = "/rest/profile/restaurants";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DishService dishService;
    @Autowired
    private VoteService voteService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllRestaurants() {
        log.info("getAllRestaurants");
        return restaurantService.getAll();

    }

    @GetMapping(value = "/{restaurantId}/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllDishesByRestaurant(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAllDishes for restaurant {}", restaurantId);
        return dishService.getAll(restaurantId);

    }

    @GetMapping(value = "/{restaurantId}/vote")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void doVote(@PathVariable("restaurantId") int restaurantId) {

        LocalDateTime now = LocalDateTime.now();
        checkTimeIsOver(now.toLocalTime());

        UserTo userTo = SecurityUtil.get().getUserTo();
        int userId = SecurityUtil.authUserId();

        Vote vote = userTo.getTodayVote().orElseGet(() -> new Vote(now.toLocalDate()));

        if (vote.isNew()) {
            log.info("create vote {} for restaurant {} from user {}", vote, restaurantId, userId);
            vote = voteService.create(vote, userId, restaurantId);
        } else {
            log.info("update vote {} for restaurant {} from user {}", vote, restaurantId, userId);
            vote = voteService.update(vote, userId, restaurantId);
        }

        userTo.setTodayVote(Optional.of(vote));
        SecurityUtil.get().update(userTo);

    }

}
