package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.halim.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	ShoppingCart findBySessionToken(String sessionToken);

//	@Query(value = "SELECT cartitem.added_on from cartitem  WHERE cartitem.user_id=id ORDER BY id DESC LIMIT 1;", nativeQuery = true)
//	public String findByDate(int id);

}
