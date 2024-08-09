package org.example.yousimservice.repository;

import org.example.yousimservice.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiRepository extends JpaRepository<Api, Integer>{

    Optional<Api> findByNameApi(String nameApi);
}
