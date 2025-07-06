package org.coderscrib.texttoemojiwithsentiment.Entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SentimentWord {
    private int score;
    private String emoji;

    public SentimentWord() {}

    public SentimentWord(int score, String emoji) {
        this.score = score;
        this.emoji = emoji;
    }

}
