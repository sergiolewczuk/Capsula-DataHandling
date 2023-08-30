package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByRoleName(String roleName);
    Optional<User> findByName(@Param("name") String name);

    List<User> findAllByAnswersCreateDateBetween(
            @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date startDate,
            @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date endDate);

    List<User> findAllByAnswersCreateDateGreaterThanEqualAndAnswersCreateDateLessThanEqual(
            @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date startDate,
            @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date endDate);


    //List<UserDTO> findAllUsersWithoutBalance();

}
