package com.kaya.marketapi.repository;

import com.kaya.marketapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAllByIdIn(Collection<Long> productIds);
}
