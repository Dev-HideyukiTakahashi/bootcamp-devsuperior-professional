package com.devsuperior.dscommerce.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.CategoryDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductMinDTO;
import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.DataBaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado! Id: " + id));
    return new ProductDTO(product);
  }

  @Transactional(readOnly = true)
  public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
    Page<Product> products = productRepository.searchByName(name, pageable);
    return products.map(entity -> new ProductMinDTO(entity));
  }

  @Transactional
  public ProductDTO insert(ProductDTO dto) {
    Product entity = new Product(dto);
    copyDtoToEntity(dto, entity);
    entity = productRepository.save(entity);
    return new ProductDTO(entity);
  }

  @Transactional
  public ProductDTO update(Long id, ProductDTO dto) {
    try {
      Product entity = productRepository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = productRepository.save(entity);
      return new ProductDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
    }
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
    }
    try {
      productRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Falha de integridade referencial!");
    }
  }

  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setPrice(dto.getPrice());
    entity.setImgUrl(dto.getImgUrl());

    entity.getCategories().clear();
    for (CategoryDTO catDTO : dto.getCategories()) {
      Category category = new Category();
      category.setId(catDTO.getId());
      entity.getCategories().add(category);
    }
  }

}
