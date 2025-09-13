package com.org.DonateLife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.DonateLife.Entity.BloodGroup;

@Repository
public interface BloodGroupRepo extends JpaRepository<BloodGroup, Integer> {

}
