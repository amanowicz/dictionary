package pl.amanowicz.dictionary.services;

import org.springframework.stereotype.Service;
import pl.amanowicz.dictionary.entities.Dictionary;
import pl.amanowicz.dictionary.exceptions.TranslationNotFound;
import pl.amanowicz.dictionary.model.TranslatedWord;
import pl.amanowicz.dictionary.repositories.DictionaryRepository;
import pl.amanowicz.dictionary.utils.Language;

@Service
public class TranslationService {

    private static final String TRANSLATION_NOT_FOUND_MSG = "Translation not found for word %s";
    private DictionaryRepository repository;

    public TranslationService(DictionaryRepository repository) {
        this.repository = repository;
    }

    public TranslatedWord translate(String word, Language language){
       Dictionary dictionary = repository.findByPolishWord(word)
               .orElseThrow(() -> new TranslationNotFound(String.format(TRANSLATION_NOT_FOUND_MSG, word)));

       return mapDictionary(dictionary, language);
    }

    private TranslatedWord mapDictionary(Dictionary dictionary, Language language){
        TranslatedWord translatedWord = new TranslatedWord();
        translatedWord.setLanguage(language);
        if (Language.EN == language){
            translatedWord.setWord(dictionary.getEnglishWord());
        }

        return translatedWord;
    }
}
