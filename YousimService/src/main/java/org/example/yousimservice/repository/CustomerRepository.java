package org.example.yousimservice.repository;

import org.example.yousimservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select cus from Customer cus where cus.provider = :provider and cus.providerId = :providerId")
    Customer findByProviderAndProviderId(String provider, String providerId);

    Customer findByEmail(String email);
}
