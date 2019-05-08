package ru.internship.ballot.util;


import org.springframework.dao.DataIntegrityViolationException;
import ru.internship.ballot.model.AbstractBaseEntity;
import ru.internship.ballot.util.exception.NotFoundException;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class ValidationUtil {

    public static final LocalTime DEADLINE_TIME = LocalTime.of(11, 0, 0);
    public static LocalTime revoteDeadLine = DEADLINE_TIME;


    private ValidationUtil() {
    }

    public static void checkDeadLineTime() {
        if (LocalTime.now().isAfter(revoteDeadLine)) {
            throw new DataIntegrityViolationException("VOTE_MODIFICATION_RESTRICTION");
        }
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

    public static void setRevoteDeadLine(LocalTime time) {
        revoteDeadLine = time;
    }

}