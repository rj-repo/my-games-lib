package com.rja.projects.mygameslib.utility.general;

import com.rja.projects.mygameslib.utility.metacritic.enums.PlatformsMetaCritic;


public class URLGenerator {

    public static String generateMetaCriticURL(PlatformsMetaCritic platform, String game) {
        String url = String.format(
                "https://www.metacritic.com/game/%s/%s",
                platform.getValue(),
                convertTitleToProperULRString(game));

        return url;
    }

    private static String convertTitleToProperULRString(String game) {
        return game.toLowerCase()
                .replace(' ', '-')
                .replace(':', '-')
                .replace("--", "-");
    }
}
