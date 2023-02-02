package com.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kootam.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
