package ru.internship.ballot.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.internship.ballot.model.Vote;
import ru.internship.ballot.service.VoteService;
import ru.internship.ballot.web.SecurityUtil;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    static final String REST_URL = "/rest/profile/votes";

    @Autowired
    private VoteService service;

    @GetMapping(value = "/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void vote(@PathVariable int restaurantId) {

        int userId = SecurityUtil.authUserId();
   /*     Optional<Vote> vote = service.getTodayVote(userId);

        vote.ifPresentOrElse(
                v -> {
                    log.info("update vote {} for user {} and restaurant {}", v.getId(), userId, restaurantId);
                    service.update(v, userId, restaurantId);
                },
                () -> {
                    log.info("create vote for user {} and restaurant {}", userId, restaurantId);
                    service.create(userId, restaurantId);
                });*/

    }

}
