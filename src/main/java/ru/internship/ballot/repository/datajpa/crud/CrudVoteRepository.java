package ru.internship.ballot.repository.datajpa.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.internship.ballot.model.Vote;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote item);

    List<Vote> getAllByUserId(int userId);
}
