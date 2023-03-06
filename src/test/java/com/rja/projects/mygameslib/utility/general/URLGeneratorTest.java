package com.rja.projects.mygameslib.utility.general;

import com.rja.projects.mygameslib.utility.metacritic.enums.PlatformsMetaCritic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URLGeneratorTest {

    @Test
    void generateMetaCriticURL() {
        String result = URLGenerator.generateMetaCriticURL(PlatformsMetaCritic.PC,"The Witcher 3: Wild Hunt");
        String expectedResult = "https://www.metacritic.com/game/pc/the-witcher-3-wild-hunt";
        assertEquals(expectedResult,result);
    }
}