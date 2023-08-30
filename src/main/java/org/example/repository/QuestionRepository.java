package org.example.repository;

import org.example.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "question", path = "question")
public interface QuestionRepository extends JpaRepository<Question, UUID> {


    @Query("SELECT COUNT(a) FROM Question q JOIN q.answers a WHERE q.detail = :detail")
    long countAnswersByDetail(String detail);

    /**
     * Lista de preguntas registradas que nunca fueron preguntadas
     * @return
     */
    @Query("SELECT DISTINCT q FROM Question q LEFT JOIN q.answers qa WHERE (qa IS NULL)")
    List<Question> findByAnswersEquals();

}
