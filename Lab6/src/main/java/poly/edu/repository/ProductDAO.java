package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{}