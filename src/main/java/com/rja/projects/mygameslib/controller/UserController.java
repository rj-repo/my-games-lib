package com.rja.projects.mygameslib.controller;

import com.c4_soft.springaddons.security.oauth2.OAuthentication;
import com.c4_soft.springaddons.security.oauth2.OpenidClaimSet;
import com.rja.projects.mygameslib.dto.GameSaveRequest;
import com.rja.projects.mygameslib.dto.UserGoogleDto;
import com.rja.projects.mygameslib.entity.Game;
import com.rja.projects.mygameslib.entity.UserGoogle;
import com.rja.projects.mygameslib.mapper.UserGoogleMapper;
import com.rja.projects.mygameslib.service.GameService;
import com.rja.projects.mygameslib.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final GameService gameService;
    private final UserGoogleMapper userGoogleMapper = Mappers.getMapper(UserGoogleMapper.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(@RequestBody UserGoogleDto userGoogleDto) {
        UserGoogle entity = userGoogleMapper.toUserGoogle(userGoogleDto);
        if (!userService.checkIfUserExists(entity.getEmail())) {
            userService.saveUser(entity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/games")
    public ResponseEntity<?> saveGameToUser(OAuthentication<OpenidClaimSet> auth, @RequestBody GameSaveRequest gameSaveRequest) {
        UserGoogle getUser = userService.getUserByEmail(auth.getClaims().getEmail());
        Game getGame = gameService.getGame(gameSaveRequest.getTitle());
        userService.saveGameToUser(getUser, getGame);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/me")
    public ResponseEntity<?> getUser(OAuthentication<OpenidClaimSet> auth) {
        UserGoogle getUser = userService.getUserByEmail(auth.getClaims().getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(getUser);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyUser(OAuthentication<OpenidClaimSet> auth, @RequestBody UserGoogleDto userGoogleDto) {
        UserGoogle getUser = userGoogleMapper.toUserGoogle(userGoogleDto);
        if (!getUser.getEmail().equals(auth.getPrincipal().getEmail())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        userService.saveUser(getUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/me")
    public ResponseEntity<?> deleteUser(OAuthentication<OpenidClaimSet> auth) {
        userService.deleteUser(auth.getPrincipal().getEmail());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
