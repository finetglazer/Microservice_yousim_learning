package org.example.webfluxdemo.repository;

import com.netflix.spectator.api.Id;
import org.example.webfluxdemo.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long>{

}
