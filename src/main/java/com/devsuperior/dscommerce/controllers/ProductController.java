package com.devsuperior.dscommerce.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(path = "/{id}")
  public ProductDTO findById(@PathVariable Long id) {
    return productService.findById(id);
  }

  @GetMapping
  public Page<ProductDTO> findAll(Pageable pageable) {
    return productService.findAll(pageable);
  }
}
