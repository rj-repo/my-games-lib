package com.rja.projects.mygameslib.service;

import com.rja.projects.mygameslib.entity.Game;

public interface GameService {

    Game getGame(String title);


    boolean existsByTitle(String name);

    Game getGameFromMetaCritic(String title);


}
