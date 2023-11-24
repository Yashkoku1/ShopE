package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.halim.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    @Query(value="select product_id from cartitem a where a.user_id= :id limit 1", nativeQuery=true)
    String findByProductId(String id);
    @Query(value="select product_id from cartitem a   where a.user_id= :userid order By added_on desc limit 1", nativeQuery=true)
    long findByRecommendedProduct(long userid);
}
