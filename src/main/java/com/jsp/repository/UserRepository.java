package com.jsp.repository;

import com.jsp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
// hello
    Optional<User> findByEmail(String email);

}
