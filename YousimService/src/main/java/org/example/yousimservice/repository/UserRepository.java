package org.example.yousimservice.repository;

import org.example.yousimservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.cusId = :customerId")
    Optional<User> findByCustomerId(Integer customerId);

    Optional<User> findByEmail(String email);
}
