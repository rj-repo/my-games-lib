package com.rja.projects.mygameslib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserGoogleDto {

    @NonNull
    private String id;

    @NonNull
    private String email;

    @NonNull
    private String name;

    private List<GameDto> game = new ArrayList<>();


}
