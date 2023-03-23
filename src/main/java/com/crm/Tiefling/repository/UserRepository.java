package com.crm.Tiefling.repository;

import com.crm.Tiefling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login like ?1")
    User loadUserByUsername(String login);

    @Query("select u from User u where u.login like ?1")
    Optional<User> findByUsername(String username);
}
