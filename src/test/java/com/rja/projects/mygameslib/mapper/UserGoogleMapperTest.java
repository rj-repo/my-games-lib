package com.rja.projects.mygameslib.mapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserGoogleMapper.class})
class UserGoogleMapperTest {

/*
    UserGoogleMapper userGoogleMapper = Mappers.getMapper(UserGoogleMapper.class);

    @Test
    void toUserGoogleDto_convertToDto_ExpectSuccess() {
        UserGoogle userGoogle = new UserGoogle("1","email","name");
        Game game1 = new Game("title1",1,"coverUrl1","PC");
        Game game2 = new Game("title2",2,"coverUrl2","PC");
        List<Game> gameList = List.of(game1,game2);

        String convertToJson = GameObjectConverter.toJson(gameList);

        userGoogle.setGames(convertToJson);

        UserGoogleDto result = userGoogleMapper.toUserGoogleDto(userGoogle);

        assertNotNull(result);
        assertThat(userGoogle.getId(),equalTo(result.getId()));
        assertThat(userGoogle.getName(),equalTo(result.getName()));
        assertThat(userGoogle.getEmail(),equalTo(result.getEmail()));
        assertThat(userGoogle.getGames(),equalTo(result.getGames()));
    }

    @Test
    void toUserGoogle_convertTo_ExpectSuccess() {
        UserGoogleDto userGoogleDto = new UserGoogleDto("1","email","name");
        Game game1 = new Game("title1",1,"coverUrl1","PC");
        Game game2 = new Game("title2",2,"coverUrl2","PC");
        List<Game> gameList = List.of(game1,game2);

        String convertToJson = GameObjectConverter.toJson(gameList);

        userGoogleDto.setGames(convertToJson);

        UserGoogle result = userGoogleMapper.toUserGoogle(userGoogleDto);

        assertNotNull(result);
        assertThat(userGoogleDto.getId(),equalTo(result.getId()));
        assertThat(userGoogleDto.getName(),equalTo(result.getName()));
        assertThat(userGoogleDto.getEmail(),equalTo(result.getEmail()));
        assertThat(userGoogleDto.getGames(),equalTo(result.getGames()));
    }

    @Test
    void fromJson_convertToGameObjects_ExpectSuccess() {
        UserGoogleDto userGoogleDto = new UserGoogleDto("1","email","name");
        Game game1 = new Game("title1",1,"coverUrl1","PC");
        Game game2 = new Game("title2",2,"coverUrl2","PC");
        List<Game> gameList = List.of(game1,game2);

        String convertToJson = GameObjectConverter.toJson(gameList);

        userGoogleDto.setGames(convertToJson);

        List<Game> resultList = GameObjectConverter.toListObject(userGoogleDto.getGames());
        Game gameResult1 = resultList.get(0);
        Game gameResult2 = resultList.get(1);

        assertNotNull(resultList);

        assertThat(game1.getTitle(),equalTo(gameResult1.getTitle()));
        assertThat(game1.getCoverUrl(),equalTo(gameResult1.getCoverUrl()));
        assertThat(game1.getRating(),equalTo(gameResult1.getRating()));
        assertThat(game1.getPlatform(),equalTo(gameResult1.getPlatform()));

        assertThat(game2.getTitle(),equalTo(gameResult2.getTitle()));
        assertThat(game2.getCoverUrl(),equalTo(gameResult2.getCoverUrl()));
        assertThat(game2.getRating(),equalTo(gameResult2.getRating()));
        assertThat(game2.getPlatform(),equalTo(gameResult2.getPlatform()));
    }

 */
}