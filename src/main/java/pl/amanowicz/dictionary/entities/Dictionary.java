package pl.amanowicz.dictionary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dictionary {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "polish_word", nullable = false)
    private String polishWord;

    @Column(name = "english_word", nullable = false)
    private String englishWord;

    public Dictionary() {
    }

    public Dictionary(Long id, String polishWord, String englishWord) {
        this.id = id;
        this.polishWord = polishWord;
        this.englishWord = englishWord;
    }

    public Long getId() {
        return id;
    }

    public String getPolishWord() {
        return polishWord;
    }

    public void setPolishWord(String polishWord) {
        this.polishWord = polishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

}
