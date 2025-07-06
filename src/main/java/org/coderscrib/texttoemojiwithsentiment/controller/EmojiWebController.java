package org.coderscrib.texttoemojiwithsentiment.controller;

import org.coderscrib.texttoemojiwithsentiment.service.EmojiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmojiWebController {

    private final EmojiService emojiService;
    public EmojiWebController(EmojiService emojiService) {
        this.emojiService = emojiService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/process")
    public String processText(@RequestParam("inputText") String inputText, Model model) {
        String replaced = emojiService.replaceWithEmojis(inputText);
        int score = emojiService.calculateSentimentScore(inputText);

        model.addAttribute("replacedText", replaced);
        model.addAttribute("score", score);
        return "index";
    }
}
