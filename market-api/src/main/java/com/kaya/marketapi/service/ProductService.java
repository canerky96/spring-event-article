package com.kaya.marketapi.service;

import com.kaya.marketapi.dto.ProductCreateRequestDTO;
import com.kaya.marketapi.model.Product;
import com.kaya.marketapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Product save(ProductCreateRequestDTO requestDTO) {
    var product = new Product();
    product.setPrice(requestDTO.getPrice());
    product.setName(requestDTO.getName());
    product.setQuantity(requestDTO.getQuantity());
    return productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public List<Product> findAllByIdIn(Collection<Long> productIds) {
    return productRepository.findAllById(productIds);
  }

  public Product findById(Long id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with given id: " + id));
  }
}
