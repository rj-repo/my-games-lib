package com.rja.projects.mygameslib.game.service;

import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.repository.GameRepository;
import com.rja.projects.mygameslib.service.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
class GameServiceImplTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @Test
    void getGame_notExistingGame_ExpectSuccess() {
        String titleGame = "Half-life";
        Game game = Game.builder()
                .id(1L)
                .title(titleGame)
                .rating(96)
                .coverUrl("https://static.metacritic.com/images/products/games/5/5764f80ddd3e67da3b29eb759e8a4737-98.jpg")
                .platform("PC").build();

        when(gameRepository.save(any(Game.class))).thenReturn(game);

        Game savedGame = gameService.getGame(titleGame);

        assertThat(savedGame.getId(),equalTo(game.getId()));
        assertThat(savedGame.getTitle(),equalTo(game.getTitle()));
        assertThat(savedGame.getCoverUrl(),equalTo(game.getCoverUrl()));
        assertThat(savedGame.getPlatform(),equalTo(game.getPlatform()));
        assertThat(savedGame.getRating(),equalTo(game.getRating()));
    }
}