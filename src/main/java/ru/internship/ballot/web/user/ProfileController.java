package ru.internship.ballot.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.internship.ballot.model.User;
import ru.internship.ballot.service.UserService;
import ru.internship.ballot.to.UserTo;
import ru.internship.ballot.util.UserUtil;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(ProfileController.REST_URL)
public class ProfileController {

    static final String REST_URL = "/rest/profile";

    @Autowired
    private UserService service;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody UserTo userTo) {

        User created = service.create(UserUtil.createNewFromTo(userTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
