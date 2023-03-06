package com.rja.projects.mygameslib.mapper;

import com.rja.projects.mygameslib.dto.UserGoogleDto;
import com.rja.projects.mygameslib.entity.UserGoogle;
import org.mapstruct.Mapper;

@Mapper
public interface UserGoogleMapper {


    UserGoogleDto toUserGoogleDto(UserGoogle userGoogle);


    UserGoogle toUserGoogle(UserGoogleDto userGoogleDto);

}
