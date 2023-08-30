package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    private Currency currency;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;
    private BigDecimal amount;

}
