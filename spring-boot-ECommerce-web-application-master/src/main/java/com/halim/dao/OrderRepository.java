package com.halim.dao;

import com.halim.model.CartItem;
import com.halim.model.CartWithUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CartWithUser, Long> {
    List<CartWithUser> findAll();
}
