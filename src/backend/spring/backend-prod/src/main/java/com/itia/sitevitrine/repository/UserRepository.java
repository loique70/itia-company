package com.itia.sitevitrine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itia.sitevitrine.beans.User;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = :status  WHERE u.id = :id")
    void updateUserStatus(@Param("id") Long id, @Param("status") short status);
}
