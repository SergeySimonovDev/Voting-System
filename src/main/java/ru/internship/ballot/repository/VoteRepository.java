package ru.internship.ballot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.internship.ballot.model.Vote;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {


    @Override
    Vote save(Vote vote);


    ///Vote save(Vote meal, int userId, int restaurantId);

 /*   @Override
    Vote getOne(Integer id);


    //Optional<Vote> get(int id, int userId);

    List<Vote> getByUser(int userId);*/

}
