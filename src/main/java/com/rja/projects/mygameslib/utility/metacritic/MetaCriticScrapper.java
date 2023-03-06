package com.rja.projects.mygameslib.utility.metacritic;

import com.rja.projects.mygameslib.exception.GameNotExists;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

@Slf4j
public class MetaCriticScrapper {

    public static int getMetaCriticReview(String url) {
        int reviewValue = 0;
        try {
            Document review = Jsoup.connect(url).get();
            Element content = review.select("span[itemprop='ratingValue']").get(0);
            reviewValue = Integer.parseInt(content.text());
        } catch (IOException e) {
            throw new GameNotExists("Game does not exist!");
        }
        return reviewValue;
    }

    public static String getMetaCriticCover(String url, String title) {
        String photoUrl = null;
        try {
            Document review = Jsoup.connect(url).get();
            photoUrl = review.select(String.format("img[alt='%s Image']", title)).get(0).absUrl("src");
        } catch (IOException e) {
            throw new GameNotExists("Game does not exist!");
        }
        return photoUrl;
    }

}
