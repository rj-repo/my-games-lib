package com.rja.projects.mygameslib.utility.metacritic;

import com.rja.projects.mygameslib.utility.general.URLGenerator;
import com.rja.projects.mygameslib.utility.metacritic.enums.PlatformsMetaCritic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MetaCriticScrapperTest {

    @Test
    public void getMetaCriticReview_getReviewValue_valueMoreThan0AndLessThan101(){
        String testUrl = URLGenerator.generateMetaCriticURL(PlatformsMetaCritic.PC,"The Witcher 3: Wild Hunt");
        int expectedResult = MetaCriticScrapper.getMetaCriticReview(testUrl);
        assertTrue(expectedResult > 0 && expectedResult <101);
    }

    @Test
    public void getMetaCriticCover_getReviewCover_urlIsValidAndContainsPhotoFormat(){
        String testUrl = URLGenerator.generateMetaCriticURL(PlatformsMetaCritic.PC,"It takes two");
        String expectedResult = MetaCriticScrapper.getMetaCriticCover(testUrl,"It takes two");
        assertNotNull(expectedResult);
        assertTrue(expectedResult.contains("jpg"),"No jpg content");
    }
}