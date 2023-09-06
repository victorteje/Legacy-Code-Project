package com.example.first.api.repositories;

import com.example.first.api.models.CLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILoginRepository extends JpaRepository<CLogin, Integer> {

    @Query(value = "SELECT * FROM login_model WHERE user_email = :userEmail AND user_password = :userPassword", nativeQuery = true)

    CLogin findByUserEmailAndUserPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    @Query(value = "SELECT * FROM login_model WHERE user_email = :userEmail", nativeQuery = true)
    CLogin findByUserEmail(String userEmail);
}
