package ru.internship.ballot.web.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/profile/votes";

    @Autowired
    private

    @GetMapping(value = "/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void vote(@PathVariable int restaurantId) {

      /*  LocalDateTime now = LocalDateTime.now();
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
    }*/
}
