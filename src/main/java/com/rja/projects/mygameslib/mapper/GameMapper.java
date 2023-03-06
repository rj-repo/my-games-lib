package com.rja.projects.mygameslib.mapper;

import com.rja.projects.mygameslib.dto.GameDto;
import com.rja.projects.mygameslib.entity.Game;
import org.mapstruct.Mapper;

@Mapper
public interface GameMapper {

    GameDto toGameDto(Game game);


    Game toGame(GameDto gameDto);
}
