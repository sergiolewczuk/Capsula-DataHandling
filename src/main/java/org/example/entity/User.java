package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    private String phone;
    @Column(nullable = false)
    private String sex;
    private String country;
    @Column(nullable = false)
    private LocalDate createDate;
    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    private Role role;
    @OneToMany(targetEntity = AnswersHistory.class, mappedBy = "user")
    private Set<AnswersHistory> answers;
    @OneToMany(targetEntity = Balance.class, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Balance> balances;


}
