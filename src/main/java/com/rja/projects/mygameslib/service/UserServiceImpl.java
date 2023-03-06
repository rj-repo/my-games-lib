package com.rja.projects.mygameslib.service;

import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.entity.UserGoogle;
import com.rja.projects.mygameslib.exception.UserAlreadyHasGame;
import com.rja.projects.mygameslib.exception.UserNotFoundException;
import com.rja.projects.mygameslib.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserGoogle saveUser(UserGoogle user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public UserGoogle updateUser(UserGoogle userGoogle) {
        return userRepository.save(userGoogle);
    }


    @Override
    public boolean checkIfUserExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserGoogle saveGameToUser(UserGoogle userGoogle, Game game) {
        if (checkIfUserHasGame(game, userGoogle.getGames())) {
            throw new UserAlreadyHasGame("User with id " + userGoogle.getId() + "already has this game!");
        }

        userGoogle.getGames().add(game);
        return userRepository.save(userGoogle);
    }

    @Override
    public UserGoogle getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not exists!"));
    }

    @Override
    public UserGoogle getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not exists!"));
    }

    private boolean checkIfUserHasGame(Game game, List<Game> games) {
        for (Game g : games) {
            if (g.equals(game)) {
                return true;
            }
        }
        return false;
    }
}
