package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    @Query("SELECT DISTINCT user FROM User user JOIN FETCH user.roles roles WHERE user.username = ?1")
    Optional<User> findByUsername(String userName);
}

