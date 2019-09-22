package pl.amanowicz.dictionary.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.amanowicz.dictionary.model.TranslatedWord;
import pl.amanowicz.dictionary.utils.Language;

import static pl.amanowicz.dictionary.validators.TranslationValidator.validate;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    @GetMapping
    public TranslatedWord translate(String word, Language translationLanguage) {
        validate(word, translationLanguage);
        TranslatedWord testWord = new TranslatedWord();
        testWord.setLanguage(Language.EN);
        testWord.setWord("cat");

        return testWord;
    }
}
