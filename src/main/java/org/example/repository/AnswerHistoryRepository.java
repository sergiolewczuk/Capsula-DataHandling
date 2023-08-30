package org.example.repository;

import org.example.entity.AnswersHistory;
import org.example.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "answerHistory", path = "answerHistory")
public interface AnswerHistoryRepository extends JpaRepository<AnswersHistory, UUID> {

    long countByQuestion(Question question);
    long countByQuestionDetail(String detail);


}
