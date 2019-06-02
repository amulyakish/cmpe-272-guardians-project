package com.guardians.cmpe272.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guardians.cmpe272.project.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>, ListingRepositoryCustom {

}
