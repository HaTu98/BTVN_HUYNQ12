package com.itlap.spring_mvc.repository;

import com.itlap.spring_mvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT  INTO users (username,password,role) values(:username, :password, :role)", nativeQuery = true)
    void insertUser (@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
