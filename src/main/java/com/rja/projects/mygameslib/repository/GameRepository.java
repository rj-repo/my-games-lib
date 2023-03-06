package com.rja.projects.mygameslib.repository;

import com.rja.projects.mygameslib.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByTitle(String title);

    boolean existsByTitle(String title);
}
