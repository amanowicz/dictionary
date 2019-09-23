package pl.amanowicz.dictionary.services;

import org.junit.Before;
import org.junit.Test;
import pl.amanowicz.dictionary.entities.Dictionary;
import pl.amanowicz.dictionary.exceptions.TranslationNotFound;
import pl.amanowicz.dictionary.model.TranslatedWord;
import pl.amanowicz.dictionary.repositories.DictionaryRepository;
import pl.amanowicz.dictionary.utils.Language;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TranslationServiceTest {

    private DictionaryRepository repository;
    private TranslationService translationService;

    @Before
    public void setup() {
        repository = mock(DictionaryRepository.class);
        translationService = new TranslationService(repository);
    }

    @Test
    public void shouldTranslateWord() {
        String word = "lew";
        TranslatedWord expectedWord = new TranslatedWord("lion", Language.EN);
        when(repository.findByPolishWord("lew")).thenReturn(Optional.of(new Dictionary(1L, "lew", "lion")));

        TranslatedWord translatedWord = translationService.translate(word, Language.EN);

        assertThat(translatedWord).isEqualTo(expectedWord);
    }

    @Test
    public void shouldThrowTranslationNotFOundException(){
        String word = "lampa";
        when(repository.findByPolishWord("lampa")).thenReturn(Optional.empty());

        assertThrows(TranslationNotFound.class, () -> translationService.translate(word, Language.EN));
    }

}