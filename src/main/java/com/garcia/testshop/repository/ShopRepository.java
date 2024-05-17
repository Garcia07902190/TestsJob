package com.garcia.testshop.repository;

import com.garcia.testshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Shop repository.
 */
@Repository
public interface ShopRepository extends JpaRepository<Product,Long> {
}
