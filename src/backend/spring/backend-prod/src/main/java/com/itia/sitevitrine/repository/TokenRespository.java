package com.itia.sitevitrine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itia.sitevitrine.beans.Token;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRespository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.user.id = :userId AND (t.expired = false OR t.revoked = false)")
    List<Token> findAllValidTokensByUserId(@Param("userId") Long userId);

    Optional<Token> findByToken(String token);
}
