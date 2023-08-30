package org.example.repository;

import org.example.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "balance", path = "balance")
public interface BalanceRepository extends JpaRepository<Balance, UUID> {

    /**
     * Saldo por username
     * @param username
     * @return
     */
    Balance findOneByUserUsername(String username);

}
