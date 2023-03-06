package com.rja.projects.mygameslib.service;

import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.repository.GameRepository;
import com.rja.projects.mygameslib.utility.general.URLGenerator;
import com.rja.projects.mygameslib.utility.metacritic.MetaCriticScrapper;
import com.rja.projects.mygameslib.utility.metacritic.enums.PlatformsMetaCritic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public Game getGame(String title) {
        if (title == null) {
            return null;
        }
        title = title.toLowerCase();
        if (existsByTitle(title)) {
            return gameRepository.findByTitle(title);
        }
        Game game = getGameFromMetaCritic(title);
        return gameRepository.save(game);
    }


    @Override
    public boolean existsByTitle(String name) {
        return gameRepository.existsByTitle(name);
    }

    @Override
    public Game getGameFromMetaCritic(String title) {
        String urlToGame = URLGenerator.generateMetaCriticURL(PlatformsMetaCritic.PC, title);
        int rating = MetaCriticScrapper.getMetaCriticReview(urlToGame);
        String coverUrl = MetaCriticScrapper.getMetaCriticCover(urlToGame, title);

        return Game.builder()
                .title(title)
                .rating(rating)
                .platform(PlatformsMetaCritic.PC.getValue())
                .coverUrl(coverUrl)
                .build();

    }


}
