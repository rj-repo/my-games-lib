package com.rja.projects.mygameslib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    @NonNull
    private Long id;

    @NonNull
    private String title;

    private int rating;

    @NonNull
    private String coverUrl;

    @NonNull
    private String platform;

}
