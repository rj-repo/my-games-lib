package com.rja.projects.mygameslib.user.service;

import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.entity.UserGoogle;
import com.rja.projects.mygameslib.exception.UserNotFoundException;
import com.rja.projects.mygameslib.repository.UserRepository;
import com.rja.projects.mygameslib.service.GameService;
import com.rja.projects.mygameslib.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    GameService gameService;

    @Test
    void saveUser_saveOneUser_ExpectSuccess() {

        UserGoogle userGoogle = new UserGoogle("1","ss","dd");


        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

        UserGoogle userCreated = userService.saveUser(userGoogle);

        verify(userRepository,times(1)).save(any(UserGoogle.class));
        assertThat(userCreated.getEmail(),equalTo(userGoogle.getEmail()));
        assertThat(userCreated.getId(),equalTo(userGoogle.getId()));
        assertThat(userCreated.getName(),equalTo(userGoogle.getName()));
    }


    @Test
    void saveGameToUser_saveToUserWithoutGames_ExpectSuccess() {
        Game game = Game.builder()
                .id(1L)
                .coverUrl("coverUrl1")
                .platform("PC")
                .rating(1)
                .title("title1")
                .build();

        UserGoogle userGoogle = new UserGoogle("1","ss","dd");

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

        UserGoogle userCreated = userService.saveUser(userGoogle);

        assertNotNull(userCreated);

        verify(userRepository,times(1)).save(any(UserGoogle.class));
        assertThat(userCreated.getEmail(),equalTo(userGoogle.getEmail()));
        assertThat(userCreated.getId(),equalTo(userGoogle.getId()));
        assertThat(userCreated.getName(),equalTo(userGoogle.getName()));


        UserGoogle userUpdated = userService.saveGameToUser(userCreated,game);


        assertNotNull(userCreated);

        assertThat(userUpdated.getEmail(),equalTo(userGoogle.getEmail()));
        assertThat(userUpdated.getId(),equalTo(userGoogle.getId()));
        assertThat(userUpdated.getName(),equalTo(userGoogle.getName()));
        assertThat(userUpdated.getGames(),equalTo(List.of(game)));

    }

    @Test
    void saveGameToUser_saveToUserWithGames_ExpectSuccess() {
        Game game1 = Game.builder()
                .id(1L)
                .coverUrl("coverUrl1")
                .platform("PC")
                .rating(1)
                .title("title1")
                .build();
        Game game2 = Game.builder()
                .id(2L)
                .coverUrl("coverUrl2")
                .platform("PC")
                .rating(2)
                .title("title2")
                .build();

        List<Game> games = new ArrayList<>();
        games.add(game1);

        UserGoogle userGoogle = new UserGoogle("1","ss","dd");
        userGoogle.setGames(games);

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

        UserGoogle userCreated = userService.saveUser(userGoogle);

        assertNotNull(userCreated);

        assertThat(userCreated.getEmail(),equalTo(userGoogle.getEmail()));
        assertThat(userCreated.getId(),equalTo(userGoogle.getId()));
        assertThat(userCreated.getName(),equalTo(userGoogle.getName()));

        when(gameService.getGame(game2.getTitle())).thenReturn(game2);

        UserGoogle userUpdated = userService.saveGameToUser(userCreated,game2);

        assertNotNull(userCreated);

        assertThat(userUpdated.getEmail(),equalTo(userGoogle.getEmail()));
        assertThat(userUpdated.getId(),equalTo(userGoogle.getId()));
        assertThat(userUpdated.getName(),equalTo(userGoogle.getName()));
        assertThat(userUpdated.getGames(),equalTo(List.of(game1,game2)));

    }


    @Test
    void checkIfUserExists_existingUser_ExpectSuccess() {
        UserGoogle userGoogle = new UserGoogle("1","ss","dd");

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

       UserGoogle created = userService.saveUser(userGoogle);

        when(userRepository.existsByEmail(created.getEmail())).thenReturn(true);
        boolean result = userService.checkIfUserExists("ss");

        assertNotNull(created);

        assertThat(result,equalTo(true));

    }

    @Test
    void checkIfUserExists_UnexistedUser_ExpectSuccess() {
        UserGoogle userGoogle = new UserGoogle("1","ss","dd");

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

       UserGoogle created = userService.saveUser(userGoogle);
        when(userRepository.existsByEmail(created.getEmail())).thenReturn(true);

        boolean result = userService.checkIfUserExists("d");

        assertThat(result,equalTo(false));

    }

    @Test
    void getUserById_getExistedUser_ExpectSuccess(){
        UserGoogle userGoogle = new UserGoogle("1","ss","dd");

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

        UserGoogle created = userService.saveUser(userGoogle);

        when(userRepository.findById("1")).thenReturn(java.util.Optional.ofNullable(created));
        UserGoogle result = userService.getUserById("1");


        assertThat(result.getEmail(),equalTo("ss"));
        assertThat(result.getId(),equalTo("1"));
        assertThat(result.getName(),equalTo("dd"));
    }

    @Test
    void getUserById_getUnexistedUser_ExpectExcpetion(){
        Exception exception = assertThrows(UserNotFoundException.class, () ->{
            userService.getUserById("das");
        });
    }

    @Test
    void getUserByEmail_getExistedUser_ExpectSuccess(){
        UserGoogle userGoogle = new UserGoogle("1","ss","dd");

        when(userRepository.save(any(UserGoogle.class))).thenReturn(userGoogle);

        UserGoogle created = userService.saveUser(userGoogle);

        when(userRepository.findByEmail("ss")).thenReturn(java.util.Optional.ofNullable(created));
        UserGoogle result = userService.getUserByEmail("ss");


        assertThat(result.getEmail(),equalTo("ss"));
        assertThat(result.getId(),equalTo("1"));
        assertThat(result.getName(),equalTo("dd"));
    }

    @Test
    void getUserByEmail_getExistedUser_ExpectException(){
        Exception exception = assertThrows(UserNotFoundException.class, () ->{
            userService.getUserByEmail("email2131");
        });
    }



}