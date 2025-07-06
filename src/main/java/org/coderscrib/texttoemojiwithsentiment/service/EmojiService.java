package org.coderscrib.texttoemojiwithsentiment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.coderscrib.texttoemojiwithsentiment.Entity.SentimentWord;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmojiService {

    private Map<String, SentimentWord> dictionary = new HashMap<>();

    @PostConstruct
    public void loadDictionary() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream input = getClass().getResourceAsStream("/EmojiFile/sentiment-emojis.json");
        TypeReference<Map<String, SentimentWord>> typeRef = new TypeReference<>() {};
        dictionary = mapper.readValue(input, typeRef);
    }

    public String replaceWithEmojis(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");

        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");

            if (dictionary.containsKey(cleanWord)) {
                result.append(dictionary.get(cleanWord).getEmoji()).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    public int calculateSentimentScore(String input) {
        int score = 0;
        String[] words = input.split(" ");

        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");
            if (dictionary.containsKey(cleanWord)) {
                score += dictionary.get(cleanWord).getScore();
            }
        }

        return score;
    }
}
