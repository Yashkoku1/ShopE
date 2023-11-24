package com.halim.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.halim.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {
	
	List<Product> findByNameContainingIgnoreCase(String name);
	@Query("SELECT DISTINCT brand FROM Product")
	List<String> findAllBrandsDistincts();
	@Query(value="select description from product a where a.id= :str limit 1", nativeQuery=true)
	String findDescription(String str);
	@Query(value="select * from product a where a.description like %:productDesc%", nativeQuery=true)
	List<Product> matchByDesc1(String productDesc);
	@Query(value="SELECT prd.id, prd.description FROM product prd", nativeQuery=true)
	List<Product> findByIdAndDescription();
	@Query(value="select * from product a where a.id= :ids", nativeQuery=true)
	List<Product> findByDetails(long ids);
}
