package pl.amanowicz.dictionary.model;

import pl.amanowicz.dictionary.utils.Language;

import java.util.Objects;

public class TranslatedWord {

    private String word;
    private Language language;

    public TranslatedWord() {
    }

    public TranslatedWord(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslatedWord that = (TranslatedWord) o;
        return Objects.equals(word, that.word) &&
                language == that.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, language);
    }

    @Override
    public String toString() {
        return "TranslatedWord{" +
                "word='" + word + '\'' +
                ", language=" + language +
                '}';
    }
}
