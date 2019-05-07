package ru.internship.ballot.util;


import ru.internship.ballot.model.AbstractBaseEntity;
import ru.internship.ballot.util.exception.NotFoundException;
import ru.internship.ballot.util.exception.VotingTimeIsOverException;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class ValidationUtil {

    public static LocalTime extremeTime = LocalTime.of(11, 0);

    private ValidationUtil() {
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkTimeIsOver(@NotNull LocalTime now) {
        if (now.isAfter(extremeTime)) {
            throw new VotingTimeIsOverException("Voting time should not exceed " + extremeTime);
        }
    }

    public static void checkNew(AbstractBaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity entity, int id) {
//      http://stackoverflow.com/a/32728226/548473
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }

    public static void setExtremeTime(LocalTime time) {
        extremeTime = time;
    }

}