package com.example.jparelationi1ex.Repository;

import com.example.jparelationi1ex.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(int id);
}
