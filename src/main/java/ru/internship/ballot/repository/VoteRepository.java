package ru.internship.ballot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.internship.ballot.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote vote);

    @Modifying
    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:todayDate")
    Vote getTodayVote(@Param("userId") int userId, @Param("todayDate") LocalDate todayDate);

}
