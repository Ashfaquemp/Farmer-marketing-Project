package com.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kootam.entity.VendorCategory;

public interface VendorCategoryRepository extends JpaRepository<VendorCategory, Long> {

}
