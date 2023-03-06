package com.rja.projects.mygameslib.repository;

import com.rja.projects.mygameslib.entity.UserGoogle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserGoogle, String> {

    Optional<UserGoogle> findByEmail(String id);

    Optional<UserGoogle> deleteByEmail(String email);

    boolean existsByEmail(String email);
}
