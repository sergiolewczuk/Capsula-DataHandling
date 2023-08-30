package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String detail;
    @Column(nullable = false)
    private Date createDateTime;
    @ManyToOne(targetEntity = User.class)
    private User createdBy;
    @OneToMany(targetEntity = AnswersHistory.class, mappedBy = "question")
    private Set<AnswersHistory> answers;

}
