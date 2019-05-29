package ru.beeline.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beeline.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
