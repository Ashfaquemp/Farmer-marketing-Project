package com.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kootam.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
