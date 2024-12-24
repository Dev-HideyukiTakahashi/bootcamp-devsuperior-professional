package com.devsuperior.dscommerce.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);
    return products.map(entity -> new ProductDTO(entity));
  }

  @Transactional
  public ProductDTO insert(ProductDTO dto) {
    Product product = new Product(dto);
    product = productRepository.save(product);
    return new ProductDTO(product);
  }

  @Transactional
  public ProductDTO update(Long id, ProductDTO dto) {
    Product entity = productRepository.getReferenceById(id);
    copyDtoToEntity(dto, entity);
    entity = productRepository.save(entity);
    return new ProductDTO(entity);
  }

  @Transactional
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setPrice(dto.getPrice());
    entity.setImgUrl(dto.getImgUrl());
  }

}
