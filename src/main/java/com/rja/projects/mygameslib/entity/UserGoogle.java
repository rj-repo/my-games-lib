package com.rja.projects.mygameslib.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_google")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class UserGoogle {

    @Id
    @NonNull
    private String id;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "games")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_games",
            joinColumns = @JoinColumn(table = "user_google", name = "id_user"),
            inverseJoinColumns = @JoinColumn(table = "games", name = "id_game"))
    private List<Game> games = new ArrayList<>();


}
