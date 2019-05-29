package ru.beeline.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beeline.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
