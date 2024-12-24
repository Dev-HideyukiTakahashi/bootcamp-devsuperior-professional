package com.devsuperior.dscommerce.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
    return new ProductDTO(product);
  }

}
