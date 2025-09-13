package com.org.DonateLife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.DonateLife.Entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
