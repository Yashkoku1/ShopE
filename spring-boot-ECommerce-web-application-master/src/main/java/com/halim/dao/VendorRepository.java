package com.halim.dao;

import com.halim.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {


    Vendor findByEmailAndPassword(String email, String password);
}
