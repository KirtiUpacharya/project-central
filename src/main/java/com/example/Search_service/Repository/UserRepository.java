package com.example.Search_service.Repository;

import com.example.Search_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find user by username
    User findByUsername(String username);
}
