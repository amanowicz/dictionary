package pl.amanowicz.dictionary.validators;

import org.springframework.util.StringUtils;
import pl.amanowicz.dictionary.exceptions.InvalidInputException;
import pl.amanowicz.dictionary.utils.Language;

public class TranslationValidator {

    private static final String EMPTY_WORD_MSG = "Word was not sent";
    private static final String EMPTY_LANGUAGE_MSG = "Language not sent";

    public static void validate(String word, Language translationLanguage) {
        validateWord(word);
        validateLanguage(translationLanguage);
    }

    private static void validateWord(String word) {
        if (StringUtils.isEmpty(word)){
            throw new InvalidInputException(EMPTY_WORD_MSG);
        }
    }

    private static void validateLanguage(Language translationLanguage){
        if (translationLanguage == null){
            throw new InvalidInputException(EMPTY_LANGUAGE_MSG);
        }
    }
}
