package ru.beeline.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beeline.demo.entity.Orderz;

public interface OrderRepository extends JpaRepository<Orderz, Long> {
}
