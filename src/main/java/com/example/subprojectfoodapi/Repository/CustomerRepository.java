package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MPHuy on 19/11/2021
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
