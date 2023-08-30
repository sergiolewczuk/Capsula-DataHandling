package org.example.repository;

import org.example.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "answer", path = "answer")
public interface AnswerRepository extends JpaRepository<Answer, UUID> {



}
