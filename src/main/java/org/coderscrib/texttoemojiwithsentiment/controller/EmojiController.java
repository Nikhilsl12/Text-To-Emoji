package org.coderscrib.texttoemojiwithsentiment.controller;

import org.coderscrib.texttoemojiwithsentiment.service.EmojiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller is for the external frontend
@RestController
@RequestMapping("/api/emoji")
public class EmojiController {

    private final EmojiService emojiService;
    public EmojiController(EmojiService emojiService) {
        this.emojiService = emojiService;
    }
    // this will be used for replacing some words in text to emoji
    @PostMapping("/replace")
    public String replaceText(@RequestBody String input) {
        return emojiService.replaceWithEmojis(input);
    }
    // It helps you to get the sentiment score of the sentence.
    @PostMapping("/score")
    public String getSentimentScore(@RequestBody String input) {
        int score = emojiService.calculateSentimentScore(input);
        return "Overall sentiment score: " + score;
    }
}

