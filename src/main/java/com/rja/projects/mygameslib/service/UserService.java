package com.rja.projects.mygameslib.service;

import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.entity.UserGoogle;

public interface UserService {

    UserGoogle saveUser(UserGoogle user);

    void deleteUser(String email);

    UserGoogle updateUser(UserGoogle userGoogle);

    boolean checkIfUserExists(String email);

    UserGoogle saveGameToUser(UserGoogle userGoogle, Game game);

    UserGoogle getUserById(String userId);

    UserGoogle getUserByEmail(String email);


}
