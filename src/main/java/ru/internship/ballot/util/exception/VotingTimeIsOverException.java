package ru.internship.ballot.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="VOTE_MODIFICATION_RESTRICTION")
public class VotingTimeIsOverException extends RuntimeException {
    public VotingTimeIsOverException(String message) {
        super(message);
    }
}
